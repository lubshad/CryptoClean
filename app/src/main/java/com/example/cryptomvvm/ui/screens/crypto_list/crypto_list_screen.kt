package com.example.cryptomvvm.ui.screens.crypto_list

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CryptoListScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Crypto List") }
            )
        }
    ) {
        LazyColumn(
            Modifier
                .fillMaxSize()

        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            for (i in 1..20) {
                item {
                    CryptoListItem()
                }
            }
        }
    }
}