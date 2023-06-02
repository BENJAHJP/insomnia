package com.example.superheroes.common

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request)
    }
}