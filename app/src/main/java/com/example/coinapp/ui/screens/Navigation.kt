package com.example.coinapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.coinapp.ui.screens.coin_details_screen.CoinDetailsScreen
import com.example.coinapp.ui.screens.coin_listing_screen.CoinListingScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.CoinListScreen.route
    ) {
        composable(route = Screens.CoinListScreen.route) {
            CoinListingScreen(navController = navController)
        }
        composable(
            route = Screens.CoinDetailsScreen.route + "?coinId={coinId}",
            arguments = listOf(navArgument("coinId") {})
        ) {
            CoinDetailsScreen(coinId = it.arguments?.getString("coinId")!!)
        }
    }
}