package com.coldfier.mynutrition3.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApiService {

    @GET("/api/food-database/v2/parser")
    suspend fun searchFood(
        @Query("ingr")
        food: String,

        @Query("app_id")
        appId: String = "489f7f8d",

        @Query("app_key")
        appKey: String = "7167ea5c65592edf16445f0543cf9d56"
    ): FoodResponse

}