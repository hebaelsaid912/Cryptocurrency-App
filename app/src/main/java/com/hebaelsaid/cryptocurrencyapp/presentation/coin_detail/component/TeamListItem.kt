package com.hebaelsaid.cryptocurrencyapp.presentation.coin_detail.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coin_detail.CoinDetailsResponseModel

@Composable
fun TeamListItem(
    teamMember: CoinDetailsResponseModel.Team,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = teamMember.name,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = teamMember.name,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }
    
}