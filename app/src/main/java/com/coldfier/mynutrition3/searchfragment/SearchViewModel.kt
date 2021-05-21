package com.coldfier.mynutrition3.searchfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coldfier.mynutrition3.retrofit.FoodApiClient
import com.coldfier.mynutrition3.retrofit.Hint
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {

    private val _foodArray = MutableLiveData<List<Hint>?>()
    val foodArray: LiveData<List<Hint>?>
        get() = _foodArray

    fun getFood(foodName: String) {
        viewModelScope.launch {
            val service = FoodApiClient.getApiService()
            val data = service.searchFood(foodName)
            if (data?.hints != null) {
                _foodArray.value = data.hints
            } else {
                _foodArray.value = listOf()
            }
        }
    }
}