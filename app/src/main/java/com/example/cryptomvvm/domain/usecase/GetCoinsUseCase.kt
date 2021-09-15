package com.example.cryptomvvm.domain.usecase

import com.example.cryptomvvm.common.Resource
import com.example.cryptomvvm.data.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@ExperimentalTime
class GetCoinsUseCase {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading<List<Coin>>())
        kotlinx.coroutines.delay(duration = Duration.seconds(3))
        val coinList = listOf<Coin>(
            Coin(name = "Bitcoin", id = "1", is_active = true),
            Coin(name = "Etherium", id = "2", is_active = true),
            Coin(name = "Deonex", id = "3", is_active = true)
        )
        emit(Resource.Success<List<Coin>>(data = coinList))
    }
}