package com.solodilov.data.mapper

import com.solodilov.data.model.CoinDetailDto
import com.solodilov.data.model.CoinDto
import com.solodilov.domain.entity.Coin
import com.solodilov.domain.entity.CoinDetail
import com.solodilov.domain.entity.Currency

fun CoinDto.toCoin(currency: Currency): Coin =
    Coin(
        id = this.id,
        image = this.image,
        name = this.name,
        symbol = this.symbol,
        currentPrice = this.currentPrice,
        priceChangePercentage = this.priceChangePercentage24h,
        currency = currency,
    )

fun CoinDetailDto.toCoinDetail(id: String): CoinDetail =
    CoinDetail(
        name = this.name,
        image = this.imageDto.large,
        description = this.descriptionDto.en,
        category = this.categories.joinToString()
    )