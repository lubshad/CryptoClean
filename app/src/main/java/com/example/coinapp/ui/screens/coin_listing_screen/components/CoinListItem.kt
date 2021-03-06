package com.example.coinapp.ui.screens.coin_listing_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.example.coinapp.common.defaultPadding
import com.example.coinapp.data.model.Coin
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun CoinListItem(coin: Coin, onClick: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = defaultPadding / 2)
        .shadow(elevation = defaultPadding / 2)
        .background(Color.White)
        .clickable {
            onClick()
        }
        .padding(defaultPadding / 2)
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(.8f),
                text = "${coin.rank}. ${coin.name}(${coin.symbol})",
                overflow = TextOverflow.Ellipsis,
                maxLines = 2)
            Text(coin.type)
        }
    }
}