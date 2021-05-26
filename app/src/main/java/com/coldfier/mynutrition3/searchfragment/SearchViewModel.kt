package com.coldfier.mynutrition3.searchfragment

import android.app.Application
import androidx.lifecycle.*
import com.coldfier.mynutrition3.cacheroom.CacheDao
import com.coldfier.mynutrition3.cacheroom.CacheDatabase
import com.coldfier.mynutrition3.models.Food
import com.coldfier.mynutrition3.repository.FoodRepository
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    private val _foodList = MutableLiveData<List<com.coldfier.mynutrition3.cacheroom.Food>>()
    val foodList: LiveData<List<com.coldfier.mynutrition3.cacheroom.Food>>
        get() = _foodList

    private lateinit var repository: FoodRepository
    private lateinit var cacheDao: CacheDao

    init {
        viewModelScope.launch {
            cacheDao = CacheDatabase.getCacheDatabase(getApplication()).cacheDao
            repository = FoodRepository(cacheDao)
            _foodList.value = repository.getCachedFood()
        }
    }

    fun getFood(foodName: String) {
        viewModelScope.launch {
            cacheDao.deleteAll()
            _foodList.value = repository.getFood(foodName)
        }
    }

/*    fun getFood(foodName: String) {
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
    } */
}