package com.example.coinapp.domain.usecase

import android.util.Log
import com.example.coinapp.common.AppErrorType
import com.example.coinapp.common.Resource
import com.example.coinapp.data.model.CoinDetails
import com.example.coinapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val coinRepository: CoinRepository,
) {

    companion object {
        const val TAG = "GetCoinDetailsUseCase"
    }

    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        emit(Resource.Loading<CoinDetails>())
        Log.i(TAG, coinId)
        try {
            val coinDetails = coinRepository.getCoinDetails(coinId)
            emit(Resource.Success<CoinDetails>(data = coinDetails))
        } catch (e: HttpException) {
            Log.i(TAG, e.localizedMessage!!)
            emit(Resource.Error<CoinDetails>(errorType = AppErrorType.ServerError))
        } catch (e: IOException) {
            Log.i(TAG, e.localizedMessage!!)
            emit(Resource.Error<CoinDetails>(errorType = AppErrorType.NetworkError))
        }
    }
}