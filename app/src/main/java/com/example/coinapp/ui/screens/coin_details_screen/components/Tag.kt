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
import com.example.coinapp.common.defaultPadding

@Composable
fun Tag(text: String) {
    Box(
        modifier = Modifier
            .padding(end = defaultPadding/2, bottom = defaultPadding/2)
            .border(width = 3.dp, shape = RoundedCornerShape(defaultPadding), color = Color.Blue)
            .padding(horizontal = defaultPadding, vertical = defaultPadding/2)
    ) {
        Text(text = text)
    }
}