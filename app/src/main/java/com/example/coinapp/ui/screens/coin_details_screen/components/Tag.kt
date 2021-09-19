package com.example.coinapp.ui.screens.coin_details_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Tag(text: String) {
    Box(
        modifier = Modifier
            .padding(end = 10.dp, bottom = 10.dp)
            .border(width = 3.dp, shape = RoundedCornerShape(20.dp), color = Color.Blue)
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(text = text)
    }
}