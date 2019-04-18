package com.appsbg.model.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HostSelectionInterceptor @Inject constructor(): Interceptor {

    private var host: String? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        host?.let {
            val url = HttpUrl.parse(host!!)
            request = request.newBuilder()
                .url(url!!)
                .build()
        }
        return chain.proceed(request)
    }
}