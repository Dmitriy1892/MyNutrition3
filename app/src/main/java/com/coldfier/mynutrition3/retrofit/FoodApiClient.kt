package com.coldfier.mynutrition3.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class FoodApiClient {

    companion object {

        private var API_SERVICE: FoodApiService? = null

        fun getApiService(): FoodApiService {
            if (API_SERVICE == null){
                //Log REST queries to logcat
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

                //Moshi
                val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

                //Retrofit
                val retrofit: Retrofit by lazy {
                    Retrofit.Builder()
                        .baseUrl("https://api.edamam.com")
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .client(client)
                        .build()
                }

                API_SERVICE = retrofit.create(FoodApiService::class.java)
            }
            return API_SERVICE as FoodApiService
        }
    }

}