package net.alexandroid.samplesapp.network

import net.alexandroid.utils.mylogkt.logI
import okhttp3.logging.HttpLoggingInterceptor

@Suppress("ConstantConditionIf")
class OkHttpLogs : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
      logI(message)
    }
}