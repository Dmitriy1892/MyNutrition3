package com.coldfier.mynutrition3.searchfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coldfier.mynutrition3.models.Food
import com.coldfier.mynutrition3.retrofit.FoodApiClient
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {

    private val _foodList = MutableLiveData<List<Food>>()
    val foodList: LiveData<List<Food>>
        get() = _foodList

    fun getFood(foodName: String) {
        viewModelScope.launch {
            val service = FoodApiClient.getApiService()
            val data = service.searchFood(foodName)
            val foods: MutableList<Food> = mutableListOf()
            if (data.hints != null) {
                data.hints.forEach{
                    hint -> hint.food?.let {
                        food -> foods.add(food)
                    }
                }
                _foodList.value = foods
            } else {
                _foodList.value = listOf()
            }
        }
    }
}