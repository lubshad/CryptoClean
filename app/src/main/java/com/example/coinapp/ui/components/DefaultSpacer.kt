package com.example.coinapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coinapp.common.defaultPadding

@Composable
fun DefaultSpacer() {
    Spacer(modifier = Modifier.height(defaultPadding))
}