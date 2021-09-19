package com.example.coinapp.ui.screens.coin_details_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.coinapp.common.Resource
import com.example.coinapp.common.coinId
import com.example.coinapp.domain.usecase.GetCoinDetailsUseCase
import com.example.coinapp.ui.screens.coin_listing_screen.CoinDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    companion object {
        const val TAG = "CoinDetailsViewModel"
    }

    val coinListState = mutableStateOf(CoinDetailsState())

    init {
        Log.i(TAG, "INIT")
        savedStateHandle.get<String>(coinId)?.let { coinId ->
            getDetails(coinId)
        }
    }

    private fun getDetails(coinId: String) {
        getCoinDetailsUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    coinListState.value = CoinDetailsState(
                        loading = false,
                        error = result.errorType,
                    )
                    Log.i(TAG, "ERROR")

                }
                is Resource.Loading -> {
                    coinListState.value = CoinDetailsState()
                    Log.i(TAG, "loading")

                }
                is Resource.Success -> {
                    coinListState.value = CoinDetailsState(
                        loading = false,
                        error = null,
                        details = result.data
                    )
                    Log.i(TAG, "Success")

                }
            }
        }.launchIn(viewModelScope)
    }
}