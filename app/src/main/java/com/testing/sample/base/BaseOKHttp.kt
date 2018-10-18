package com.testing.sample.base

import com.testing.sample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

open class BaseOKHttp{
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

        //show logs if app is in Debug mode
//        if (BuildConfig.DEBUG)
            okHttpClient.addInterceptor(provideHttpLoggingInterceptor())
        return okHttpClient.build()
    }

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }
}