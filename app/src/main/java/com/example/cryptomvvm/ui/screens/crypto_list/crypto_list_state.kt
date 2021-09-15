package com.example.cryptomvvm.ui.screens.crypto_list

import com.example.cryptomvvm.data.model.Coin

class CryptoListState(
    val loading: Boolean = true,
    val data: List<Coin> = emptyList(),
    val error: String = ""
)