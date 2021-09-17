package com.example.coinapp.ui.screens.coin_details_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coinapp.ui.screens.Screens
import com.example.coinapp.ui.screens.coin_listing_screen.components.CoinListItem

@Composable
fun CoinDetailsScreen(coinId: String , coinDetailsViewModel: CoinDetailsViewModel = hiltViewModel()) {


    val state = coinDetailsViewModel.coinListState.value

    Scaffold {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when {
                state.loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                state.error != null -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = state.error.errorMessage())
                    }

                }
                else -> {
                    LazyColumn {
                        item {

                            Text(text = state.details?.description.toString())
                        }
                    }
                }
            }
        }
    }
}