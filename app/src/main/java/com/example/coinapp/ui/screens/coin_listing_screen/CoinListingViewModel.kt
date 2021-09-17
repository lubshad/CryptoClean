package com.example.coinapp.ui.screens.coin_listing_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapp.common.Resource
import com.example.coinapp.domain.usecase.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinListingViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {

    companion object {
        const val TAG = "CoinViewModel"
    }

    val coinListState = mutableStateOf(CoinListState())


    init {

        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    coinListState.value = CoinListState(
                        loading = false,
                        error = result.errorType,
                    )
                    Log.i(TAG, "ERROR")

                }
                is Resource.Loading -> {
                    coinListState.value = CoinListState()
                    Log.i(TAG, "loading")

                }
                is Resource.Success -> {
                    coinListState.value = CoinListState(
                        loading = false,
                        error = null,
                        coins = result.data
                    )
                    Log.i(TAG, "Success")

                }
            }
        }.launchIn(viewModelScope)
    }
}