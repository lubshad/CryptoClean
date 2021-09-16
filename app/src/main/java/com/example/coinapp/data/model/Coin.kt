package com.example.coinapp.data.model

data class Coin(
    val id: String = "1",
    val is_active: Boolean = true,
    val is_new: Boolean = true,
    val name: String = "Bitcoin",
    val rank: Int = 1,
    val symbol: String = "BTC",
    val type: String = "Coin"
)