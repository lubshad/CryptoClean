package com.example.coinapp.ui.screens.coin_listing_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.coinapp.data.model.Coin


@Composable
fun CoinListItem(coin: Coin, onClick: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
        .shadow(elevation = 10.dp)
        .background(Color.White)
        .clickable {
            onClick()
        }
        .padding(10.dp)


    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()

        ) {
            Text("${coin.rank}. ${coin.name}(${coin.symbol})")
            Text(coin.type)
        }
    }
}