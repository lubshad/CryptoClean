package com.example.coinapp.ui.screens.coin_listing_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.coinapp.common.defaultPadding
import com.example.coinapp.ui.screens.Screens
import com.example.coinapp.ui.screens.coin_listing_screen.components.CoinListItem
import com.example.coinapp.ui.screens.coin_listing_screen.components.SearchField

@Composable
fun CoinListingScreen(
    coinListingViewModel: CoinListingViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    val state = coinListingViewModel.coinListState.value
    val listState = rememberLazyListState()


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
                    Column(modifier = Modifier.padding(horizontal = defaultPadding / 2)) {

                        SearchField(listState = listState)
                        LazyColumn(
                            state = listState,
                            modifier = Modifier
                                .fillMaxHeight()


                        ) {
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
}


