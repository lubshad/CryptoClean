package com.example.coinapp.ui.screens.coin_details_screen.components


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.coinapp.data.model.Team

@Composable
fun Team(team: Team) {
    Box(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth()
            .border(width = 1.dp,
            shape = RoundedCornerShape(5.dp),
            color = Color.Gray)
            .padding(10.dp)
    ) {
        Column {
            HeaderText(text = team.name)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = team.position, style = MaterialTheme.typography.caption)
        }
    }
}