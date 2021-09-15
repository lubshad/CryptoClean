package com.example.cryptomvvm.ui.screens.crypto_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CryptoListItem() {
    Box(modifier = Modifier
        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
        .shadow(elevation = 10.dp)
        .background(color = Color.White)
        .padding(vertical = 20.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "1")
            Text(text = "Bitcoin")
            Text(text = "active")
        }
    }
}