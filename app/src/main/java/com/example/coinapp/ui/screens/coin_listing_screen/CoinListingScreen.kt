package com.example.coinapp.ui.screens.coin_listing_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
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
    navController: NavHostController,
) {

    val state = coinListingViewModel.coinListState.value


    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Coin App")
        })
    }) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when {
                state.loading -> {
                    CircularProgressIndicator()
                }
                state.error != null -> {
                    Text(text = state.error.errorMessage())

                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.padding(horizontal = 10.dp)
                    ) {

                        item {
                            SearchField()
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
}

@Composable
fun SearchField() {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 10.dp),
        value = "", onValueChange = {})
}
