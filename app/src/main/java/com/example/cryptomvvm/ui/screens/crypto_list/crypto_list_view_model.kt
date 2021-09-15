package com.example.cryptomvvm.ui.screens.crypto_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class CryptoListViewModel : ViewModel() {

    private val _state = mutableStateOf(CryptoListState())

    val state = _state.value

    init {
        getAllCoins()
    }

    fun getAllCoins() {

    }
}