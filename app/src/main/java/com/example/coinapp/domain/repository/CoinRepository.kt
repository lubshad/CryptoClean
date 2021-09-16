package com.example.coinapp.domain.repository

import com.example.coinapp.data.model.CoinList


interface CoinRepository {
    suspend fun getAllCoins(): CoinList
}