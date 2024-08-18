package com.solodilov.coin.screen.coin_detail

import com.solodilov.domain.entity.CoinDetail

sealed class CoinDetailScreenState {
    data object Loading : CoinDetailScreenState()
    data class Content(val content: CoinDetail) : CoinDetailScreenState()
    data object Error : CoinDetailScreenState()
}