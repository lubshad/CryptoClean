package com.example.coinapp.ui.screens.coin_listing_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coinapp.ui.screens.coin_listing_screen.components.CoinListItem

@Composable
fun CoinListingScreen(
    coinListingViewModel: CoinListingViewModel = viewModel()
) {

    val loading = coinListingViewModel.loading.value
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Coin App")
        })
    }) {
        if (loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    CircularProgressIndicator()
                    Button(onClick = {
                        coinListingViewModel.changeLoading()
                    }) {

                    }
                }
            }
        } else {

            LazyColumn {
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }
                for (i in 1..20) {
                    item {
                        CoinListItem()
                    }
                }
            }
        }
    }
}