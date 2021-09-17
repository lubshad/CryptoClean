package com.example.coinapp.ui.screens.coin_listing_screen

import com.example.coinapp.common.AppErrorType
import com.example.coinapp.data.model.CoinDetails

data class CoinDetailsState(
    val loading: Boolean = true,
    val error: AppErrorType? = null,
    val details: CoinDetails? = null,
)
