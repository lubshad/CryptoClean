package com.example.coinapp.ui.screens.coin_listing_screen

import com.example.coinapp.common.AppErrorType
import com.example.coinapp.data.model.Coin

data class CoinListState(
    val loading: Boolean = true,
    val error: AppErrorType? = null,
    val coins: List<Coin>? = emptyList<Coin>()
)
