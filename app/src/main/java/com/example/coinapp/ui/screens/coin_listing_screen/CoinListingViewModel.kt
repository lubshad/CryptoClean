package com.example.coinapp.ui.screens.coin_listing_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoinListingViewModel : ViewModel() {
    val loading = mutableStateOf(true)


    init {
        viewModelScope.launch(Dispatchers.Main) {
            fetchData()
        }
    }

    private suspend fun fetchData() {
        delay(3000L)
        loading.value = false
    }
}