package com.coldfier.mynutrition3.repository

import com.coldfier.mynutrition3.cacheroom.CacheDao
import com.coldfier.mynutrition3.cacheroom.Nutrients
import com.coldfier.mynutrition3.models.Food
import com.coldfier.mynutrition3.retrofit.FoodApiClient

class FoodRepository(private val cacheDao: CacheDao) {

    suspend fun getFood(foodName: String): List<com.coldfier.mynutrition3.cacheroom.Food> {
        val service = FoodApiClient.getApiService()
        val data = service.searchFood(foodName)
        val foods: MutableList<com.coldfier.mynutrition3.cacheroom.Food> = mutableListOf()
        if (data.hints != null) {
            data.hints.forEach{
                    hint -> hint.food?.let {
                        food -> foods.add(foodAdapter(food))
                    }
            }
        }
        cacheDao.insertAll(*foods.toTypedArray())
        return foods
    }

    suspend fun getCachedFood(): List<com.coldfier.mynutrition3.cacheroom.Food> {
        return cacheDao.getCachedFood()
    }

    private fun cacheAdapter(foodList: List<Food>): List<com.coldfier.mynutrition3.cacheroom.Food> {
        val cachedFood = mutableListOf<com.coldfier.mynutrition3.cacheroom.Food>()
        foodList.forEach {
            food -> cachedFood.add(
                foodAdapter(food)
            )
        }
        return cachedFood
    }

    private fun foodAdapter(food: Food): com.coldfier.mynutrition3.cacheroom.Food {


         if (food != null) {
             val cachedFood =  com.coldfier.mynutrition3.cacheroom.Food(
                 foodId = food.foodId!!,
                 label = food.label!!,
                 nutrients = Nutrients(
                     calories = food.nutrients!!.calories!!,
                     protein = food.nutrients!!.protein!!,
                     fat = food.nutrients!!.fat!!,
                     carb = food.nutrients!!.carb!!
                 ),
                 category = food.category!!,
                 categoryLabel = food.categoryLabel!!,
                 image = food.image!!
             )

             return cachedFood
         } else throw NullPointerException("null in foodAdapter!")
    }
}