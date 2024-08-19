package com.solodilov.coin.screen.coin_detail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.solodilov.coin.screen.coin_detail.business.CoinDetailScreenState
import com.solodilov.coin.screen.coin_detail.business.CoinDetailsViewModel
import com.solodilov.coin.screen.common.ErrorScreen
import com.solodilov.coin.screen.common.LoadingScreen
import com.solodilov.util.R
import com.solodilov.util.navigation.Routes
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CoinDetailsScreen(
    coinId: String,
    coinName: String,
    navigateTo: (String) -> Unit,
    viewModel: CoinDetailsViewModel = koinViewModel { parametersOf(coinId) },
    ) {

    val uiState by viewModel.uiState.collectAsState()

    Column {
        CoinDetailsToolbar(
            coinName = coinName,
            onBackClick = { navigateTo(Routes.CoinList) }
            )
        when (uiState) {
            is CoinDetailScreenState.Content -> {
                val coinDetail = (uiState as CoinDetailScreenState.Content).content
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Image(
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape),
                            painter = rememberAsyncImagePainter(coinDetail.image),
                            contentDescription = "Coin image",
                        )
                    }
                    Text(
                        text = stringResource(id = R.string.description),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    HtmlText(html = coinDetail.description)
                    Text(
                        text = stringResource(id = R.string.categories),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Text(
                        text = coinDetail.category,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }

            }

            CoinDetailScreenState.Error -> { ErrorScreen(onClick = { viewModel.loadCoinDetails() }) }
            CoinDetailScreenState.Loading -> { LoadingScreen() }
        }
    }
}