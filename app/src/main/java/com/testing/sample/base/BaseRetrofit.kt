package com.testing.sample.base

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class BaseRetrofit: BaseOKHttp(){

    val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun gsonBuilder(): Gson {
        return GsonBuilder()
                .setLenient()
                .create()
    }

    fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(provideOKHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}