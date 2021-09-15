package com.example.coinapp.ui.screens.coin_listing_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
                CircularProgressIndicator()
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