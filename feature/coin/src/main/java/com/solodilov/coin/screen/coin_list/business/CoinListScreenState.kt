package com.solodilov.coin.screen.coin_list.business

import com.solodilov.domain.entity.Coin

sealed class CoinListScreenState {
    data object Loading : CoinListScreenState()
    data class Content(val content: List<Coin>) : CoinListScreenState()
    data object Error : CoinListScreenState()
}