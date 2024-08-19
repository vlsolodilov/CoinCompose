package com.solodilov.coin.di

import com.solodilov.coin.screen.coin_detail.business.CoinDetailsViewModel
import com.solodilov.coin.screen.coin_list.business.CoinListViewModel
import com.solodilov.domain.usecase.GetCoinListUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coinModule = module {
    viewModel {
        CoinListViewModel(
            getCoinListUseCase = GetCoinListUseCase(get())
        )
    }
    viewModel { (coinId: String) ->
        CoinDetailsViewModel(
            coinId = coinId,
            getCoinDetailUseCase = get(),
        )
    }
}