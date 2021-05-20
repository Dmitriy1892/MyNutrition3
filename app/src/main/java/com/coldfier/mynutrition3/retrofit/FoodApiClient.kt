package com.coldfier.mynutrition3.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class FoodApiClient {

    fun getApiService(): FoodApiService {
        //Log REST queries to logcat
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(Hints::class.java)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.edamam.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()

        return retrofit.create(FoodApiService::class.java)
    }

}