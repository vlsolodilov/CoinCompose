package com.solodilov.domain.usecase

import com.solodilov.domain.entity.CoinDetail
import com.solodilov.domain.repository.CoinRepository

class GetCoinDetailUseCase(private val repository: CoinRepository) {
    suspend operator fun invoke(id: String): Result<CoinDetail> =
        repository.getCoinDetail(id)
}