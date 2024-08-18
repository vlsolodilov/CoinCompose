package com.solodilov.data.repository

import com.solodilov.data.mapper.toCoin
import com.solodilov.data.mapper.toCoinDetail
import com.solodilov.data.model.CoinDetailDto
import com.solodilov.data.model.CoinDto
import com.solodilov.data.network.ApiService
import com.solodilov.domain.entity.Coin
import com.solodilov.domain.entity.CoinDetail
import com.solodilov.domain.entity.Currency
import com.solodilov.domain.repository.CoinRepository
import io.ktor.client.call.body

class CoinRepositoryImpl(
    private val apiService: ApiService,
) : CoinRepository {
    override suspend fun getCoinList(currency: Currency): Result<List<Coin>> =
        runCatching {
            apiService.getCoinList(currency.name)
                .body<List<CoinDto>>().map { it.toCoin(currency) }
        }

    override suspend fun getCoinDetail(id: String): Result<CoinDetail> =
        runCatching {
            apiService.getCoinDetail(id).body<CoinDetailDto>().toCoinDetail(id)
        }
}