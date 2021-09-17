package com.example.coinapp.ui.screens.coin_listing_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.coinapp.ui.screens.Screens
import com.example.coinapp.ui.screens.coin_listing_screen.components.CoinListItem

@Composable
fun CoinListingScreen(
    coinListingViewModel: CoinListingViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val state = coinListingViewModel.coinListState.value


    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Coin App")
        })
    }) {
        when {
            state.loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            state.error != null -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = state.error.errorMessage())
                }

            }
            else -> {
                LazyColumn {
                    item {
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                    items(state.coins!!) { coin ->
                        CoinListItem(coin = coin, onClick = {
                            navController.navigate(route = Screens.CoinDetailsScreen.route + "?coinId=${coin.id}")
                        })
                    }

                }
            }
        }
    }
}