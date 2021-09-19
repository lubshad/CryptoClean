package com.example.coinapp.ui.screens.coin_listing_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapp.common.Resource
import com.example.coinapp.data.model.Coin
import com.example.coinapp.domain.usecase.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinListingViewModel @Inject constructor(
    getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {

    companion object {
        const val TAG = "CoinViewModel"
    }


    private var coinList = emptyList<Coin>()

    val coinListState = mutableStateOf(CoinListState())
    var searchText = mutableStateOf("")

    fun clearSearch() {
        searchText.value = ""
        coinListState.value = CoinListState(
            loading = false,
            error = null,
            coins = coinList
        )
    }

    fun searchCoin(text: String) {
        Log.i(TAG, searchText.value)
        searchText.value = text
        if (text == "") {
            coinListState.value = CoinListState(
                loading = false,
                error = null,
                coins = coinList
            )
        } else {
            val searchResult = coinList.filter {
                it.name.contains(
                    searchText.value.lowercase(),
                    ignoreCase = true
                )

            }
            coinListState.value = CoinListState(
                loading = false,
                error = null,
                coins = searchResult
            )
        }

    }


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
                    coinList = result.data!!
                    coinListState.value = CoinListState(
                        loading = false,
                        error = null,
                        coins = coinList
                    )
                    Log.i(TAG, "Success")

                }
            }
        }.launchIn(viewModelScope)
    }
}