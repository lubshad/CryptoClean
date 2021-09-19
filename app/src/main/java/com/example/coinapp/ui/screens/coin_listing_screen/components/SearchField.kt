package com.example.coinapp.ui.screens.coin_listing_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coinapp.common.defaultPadding
import com.example.coinapp.ui.screens.coin_listing_screen.CoinListingViewModel
import kotlinx.coroutines.launch

@Composable
fun SearchField(
    coinListingViewModel: CoinListingViewModel = hiltViewModel(),
    listState: LazyListState,
) {
    val coroutineScope = rememberCoroutineScope()
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = defaultPadding / 2),
        value = coinListingViewModel.searchText.value,
        onValueChange = {
            coinListingViewModel.searchCoin(it)
            coroutineScope.launch {
                listState.animateScrollToItem(index = 0)
            }
        },
        placeholder = { Text("Enter Coin Name") },
        label = { Text(text = "Search Coin") },
        trailingIcon = {IconButton(onClick = {
            if(coinListingViewModel.searchText.value != "") coinListingViewModel.clearSearch()
        }) {
           Icon(imageVector = if(coinListingViewModel.searchText.value != "") Icons.Default.Clear  else  Icons.Default.Search, contentDescription = "")
        }},
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {

            }
        )

    )
}


