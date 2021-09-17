package com.example.coinapp.domain.repository

import com.example.coinapp.data.model.CoinDetails
import com.example.coinapp.data.model.CoinList


interface CoinRepository {
    suspend fun getAllCoins(): CoinList
    suspend fun getCoinDetails(coinId: String): CoinDetails
}