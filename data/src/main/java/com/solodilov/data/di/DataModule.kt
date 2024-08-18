package com.solodilov.data.di

import com.solodilov.data.network.ApiService
import com.solodilov.data.network.httpClientAndroid
import com.solodilov.data.repository.CoinRepositoryImpl
import com.solodilov.domain.repository.CoinRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {
    single { ApiService(get()) }
    single<HttpClient> { provideHttpClient() }
    single<CoinRepository> { CoinRepositoryImpl(get()) }
}

fun provideHttpClient(): HttpClient = httpClientAndroid

