package com.coldfier.mynutrition3.searchfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coldfier.mynutrition3.retrofit.FoodApiClient
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {

    fun getFood() {
        viewModelScope.launch {
            val service = FoodApiClient().getApiService()
            val result = service.searchFood("apple")
            val anyres = service
        }

    }

}