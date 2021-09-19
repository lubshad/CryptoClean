package com.example.coinapp.ui.screens.coin_details_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coinapp.ui.components.DefaultSpacer
import com.example.coinapp.ui.components.HeaderText
import com.example.coinapp.ui.screens.coin_details_screen.components.Tag
import com.example.coinapp.ui.screens.coin_details_screen.components.Team
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
                .padding(horizontal = 20.dp),
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
                    val details = state.details!!
                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
                        item {
                            DefaultSpacer()
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween) {
                                HeaderText(text = "${details.rank}. ${details.name}(${details.symbol})")
                                Text(if (details.is_active) "active" else "inactive")
                            }
                            DefaultSpacer()
                            Text(text = details.description)
                            DefaultSpacer()

                            HeaderText(text = "Tags")
                            DefaultSpacer()

                            FlowRow {
                                details.tags.forEach {
                                    Tag(text = it.name)
                                }

                            }
                            DefaultSpacer()
                            HeaderText("Team Members")
                            DefaultSpacer()
                            Column {
                                details.team.forEach {
                                    Team(it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}