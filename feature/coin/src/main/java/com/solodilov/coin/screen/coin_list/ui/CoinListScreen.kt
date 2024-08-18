package com.solodilov.coin.screen.coin_list.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.solodilov.coin.screen.coin_list.business.CoinListScreenState
import com.solodilov.coin.screen.coin_list.business.CoinListViewModel
import com.solodilov.domain.entity.Currency
import com.solodilov.util.navigation.Destinations
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoinListScreen(
    navigateWithArgument: (String, String) -> Unit,
    viewModel: CoinListViewModel = koinViewModel(),
) {

    val currency by viewModel.currency.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    Column {
        CoinListToolbar(
            currencyList = Currency.entries,
            selected = currency,
            onSelected = viewModel::onSelectedCurrency,
        )
        when (uiState) {
            is CoinListScreenState.Content -> {
                val coinList = (uiState as CoinListScreenState.Content).content
                LazyColumn {
                    items(
                        items = coinList,
                        key = { it.id }
                    ) { coin ->
                        CoinItem(
                            coin = coin,
                            onClick = {
                                navigateWithArgument(Destinations.CoinDetailsScreen, coin.id)
                            }
                        )
                    }
                }
            }

            CoinListScreenState.Error -> {
            }

            CoinListScreenState.Loading -> {}
        }

    }

}