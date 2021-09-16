package com.example.coinapp.domain.usecase

import android.util.Log
import com.example.coinapp.common.Resource
import com.example.coinapp.data.model.Coin
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCoinsUseCase {
    companion object {
        const val TAG = "CoinUseCase"
    }

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())
        val coins = getData()
        emit(Resource.Success<List<Coin>>(data = coins))
    }

    private suspend fun getData():List<Coin> {
        Log.i(TAG, "GET data start")
        delay(5000L)
        val coinList : MutableList<Coin> = mutableListOf()
        for (i in 1..20) {
            coinList.add(Coin(id = i.toString()))
        }
        return coinList
    }
}