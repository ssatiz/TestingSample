package com.bpmlinks.utility.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

open class BaseOKHttp {
    companion object {
        const val NETWORK_CONNECTION_TIMEOUT = 1L
        const val NETWORK_READ_TIMEOUT = 30L
        const val NETWORK_WRITE_TIMEOUT = 15L
    }

    fun provideOKHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient
                .connectTimeout(NETWORK_CONNECTION_TIMEOUT, TimeUnit.MINUTES)
                .readTimeout(NETWORK_READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(NETWORK_WRITE_TIMEOUT, TimeUnit.SECONDS)

//        if (BuildConfig.DEBUG)
//        okHttpClient.addInterceptor(provideHttpLoggingInterceptor())
        return okHttpClient.build()
    }

    fun provideHeaderInterceptor(headers: HashMap<String, String>): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()?.newBuilder()
            headers.forEach {
                request?.addHeader(it.key, it.value)
            }
            chain.proceed(request!!.build())
        }

    }

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }
}