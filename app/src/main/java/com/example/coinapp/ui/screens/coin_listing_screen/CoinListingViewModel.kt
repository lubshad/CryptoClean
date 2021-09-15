package com.example.coinapp.ui.screens.coin_listing_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CoinListingViewModel : ViewModel() {
    val loading = mutableStateOf(true)

    fun changeLoading() {
        loading.value = false
    }
}