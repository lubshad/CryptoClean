package com.example.coinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.coinapp.ui.screens.coin_listing_screen.CoinListingScreen
import com.example.coinapp.ui.theme.CoinAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinAppTheme {
                CoinListingScreen()
            }
        }
    }
}
