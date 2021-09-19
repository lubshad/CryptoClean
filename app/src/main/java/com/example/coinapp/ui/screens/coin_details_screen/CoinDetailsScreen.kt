package com.example.coinapp.ui.screens.coin_details_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailsScreen(
    coinDetailsViewModel: CoinDetailsViewModel = hiltViewModel(),
) {


    val state = coinDetailsViewModel.coinListState.value

    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.TopStart
        ) {
            when {
                state.loading -> {
                    CircularProgressIndicator()
                }
                state.error != null -> {
                    Text(text = state.error.errorMessage())

                }
                else -> {
                    val details = state.details!!
                    LazyColumn {
                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween) {
                                Text("${details.rank}. ${details.name}(${details.symbol})")
                                Text(if (details.is_active) "active" else "inactive")
                            }
                            Text(text = details.description)
                            Text(text = "Tags")
                            FlowRow() {
                                details.tags.forEach {
                                    Text(text = it.name)
                                }

                            }
                            Text("Team Members")
                            Column {
                                details.team.forEach {
                                    Card(
                                        border = BorderStroke(width = 1.dp, color = Color.Gray)
                                    ) {
                                        Column() {
                                            Text(text = it.name)
                                            Text(text = it.position)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}