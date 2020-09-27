package net.alexandroid.samplesapp.network

import kotlinx.coroutines.delay
import net.alexandroid.utils.mylogkt.logE

sealed class NetworkResponse<T>
class Success<T>(val data: T) : NetworkResponse<T>()
class Fail<T>(val e: Exception) : NetworkResponse<T>()

suspend fun <T> retryThis(
    times: Int = 3,
    initialDelay: Long = 500, // 1/2 second
    maxDelay: Long = 4000,    // 4 seconds
    factor: Double = 2.0,
    desc: String = "",
    block: suspend () -> T?
): NetworkResponse<T> {
    var currentDelay = initialDelay
    var tempException: java.lang.Exception? = null
    repeat(times) {
        try {
            val result = block()
            if (result != null) return Success(result)
        } catch (e: Exception) {
            tempException = e
            printLog(e, desc, it)
        }

        delay(currentDelay)
        currentDelay = (currentDelay * factor).toLong().coerceAtMost(maxDelay)
    }
    return Fail(tempException ?: IllegalStateException("Unknown Exception"))
}

private fun printLog(e: Exception, desc: String, it: Int) {
    logE(
        "Description (${e.javaClass.simpleName}): $desc, fail counter: ${it + 1}, Exception: ${e.message} ",
        t = e
    )
}
