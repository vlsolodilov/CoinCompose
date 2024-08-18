package com.solodilov.domain.repository

import com.solodilov.domain.entity.Coin
import com.solodilov.domain.entity.CoinDetail
import com.solodilov.domain.entity.Currency

interface CoinRepository {
    suspend fun getCoinList(currency: Currency): Result<List<Coin>>
    suspend fun getCoinDetail(id: String): Result<CoinDetail>
}