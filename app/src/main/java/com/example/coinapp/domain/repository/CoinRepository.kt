package com.example.coinapp.domain.repository

import com.example.coinapp.data.model.Coin
import com.example.coinapp.data.model.CoinList


interface CoinRepository {
    fun getAllCoins() :CoinList
}