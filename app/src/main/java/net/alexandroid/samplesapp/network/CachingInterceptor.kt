package net.alexandroid.samplesapp.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CachingInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        request = if (NetworkUtil.hasNetwork(context)) {
            request.newBuilder()
                .header("Cache-Control", "public, max-age=" + 60 * 5) // 5 minutes
                .build()
        } else {
            request.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7) // A week
                .build()
        }
        return chain.proceed(request)
    }
}