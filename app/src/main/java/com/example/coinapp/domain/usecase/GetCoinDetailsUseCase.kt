package com.example.coinapp.domain.usecase

import android.util.Log
import com.example.coinapp.common.AppErrorType
import com.example.coinapp.common.Resource
import com.example.coinapp.data.model.Coin
import com.example.coinapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    companion object {
        const val TAG = "GetCoinDetailsUseCase"
    }

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading<List<Coin>>())
        try {
            val coins =coinRepository.getAllCoins().map { it }

            emit(Resource.Success<List<Coin>>(data = coins))
        }
        catch (e: HttpException) {
            Log.i(TAG, e.localizedMessage)
            emit(Resource.Error<List<Coin>>(errorType = AppErrorType.ServerError))
        }
        catch (e:IOException) {
            Log.i(TAG, e.localizedMessage)
            emit(Resource.Error<List<Coin>>(errorType = AppErrorType.NetworkError))
        }
    }
}