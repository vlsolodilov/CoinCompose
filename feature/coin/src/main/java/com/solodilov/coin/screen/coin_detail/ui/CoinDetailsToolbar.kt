package com.solodilov.coin.screen.coin_detail.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.solodilov.util.R

@Composable
fun CoinDetailsToolbar(
    modifier: Modifier = Modifier,
    coinName: String,
    onBackClick: () -> Unit,
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 8.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onBackClick() },
            )
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = coinName,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}