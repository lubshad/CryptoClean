package com.example.coinapp.data.data_source.remote

import com.example.coinapp.data.model.CoinDetails
import com.example.coinapp.data.model.CoinList
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getAllCoins() : CoinList

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetails(@Path(value = "coinId") coinId:String ): CoinDetails


}