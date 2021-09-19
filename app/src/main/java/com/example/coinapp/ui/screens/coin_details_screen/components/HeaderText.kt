package com.example.coinapp.ui.screens.coin_details_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HeaderText(text :String) {
    Text(
        modifier = Modifier.fillMaxWidth(.8f),
        text = text, style = MaterialTheme.typography.h6)
}