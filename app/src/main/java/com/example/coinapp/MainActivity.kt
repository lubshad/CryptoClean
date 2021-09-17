package com.example.coinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.coinapp.ui.screens.Navigation
import com.example.coinapp.ui.theme.CoinAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinAppTheme {
                Navigation()
//                CoinListingScreen(navController = navController)
            }
        }
    }
}
