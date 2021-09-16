package com.example.coinapp.data.repository

import android.util.Log
import com.example.coinapp.data.data_source.remote.CoinPaprikaApi
import com.example.coinapp.data.model.CoinList
import com.example.coinapp.domain.repository.CoinRepository
import javax.inject.Inject


class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
) : CoinRepository {

    companion object {
        const val TAG = "CoinRepository"
    }

    override suspend fun getAllCoins(): CoinList {
        Log.i(TAG, "API CALL")
        return coinPaprikaApi.getAllCoins()
    }

}