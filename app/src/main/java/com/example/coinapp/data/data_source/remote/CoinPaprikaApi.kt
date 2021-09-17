package com.example.coinapp.data.data_source.remote

import com.example.coinapp.data.model.CoinList
import retrofit2.http.GET

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getAllCoins() : CoinList


}