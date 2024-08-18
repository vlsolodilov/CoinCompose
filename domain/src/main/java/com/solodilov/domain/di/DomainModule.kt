package com.solodilov.domain.di

import com.solodilov.domain.usecase.GetCoinDetailUseCase
import com.solodilov.domain.usecase.GetCoinListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetCoinListUseCase(repository = get()) }
    factory { GetCoinDetailUseCase(repository = get()) }
}