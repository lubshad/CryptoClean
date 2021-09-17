package com.example.coinapp.ui.screens

sealed class Screens(val route: String){
    object CoinListScreen : Screens("coin_list_screen")
    object CoinDetailsScreen : Screens("coin_details_screen")
}
