package com.solodilov.domain.usecase

import com.solodilov.domain.entity.Coin
import com.solodilov.domain.entity.Currency
import com.solodilov.domain.repository.CoinRepository

class GetCoinListUseCase (private val repository: CoinRepository) {
    suspend operator fun invoke(currency: Currency): Result<List<Coin>> =
        repository.getCoinList(currency)
}