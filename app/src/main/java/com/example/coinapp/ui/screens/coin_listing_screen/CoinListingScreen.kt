package com.example.coinapp.ui.screens.coin_listing_screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coinapp.ui.screens.coin_listing_screen.components.CoinListItem

@Composable
fun CoinListingScreen() {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Coin App")
        })
    }) {
        LazyColumn  {
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