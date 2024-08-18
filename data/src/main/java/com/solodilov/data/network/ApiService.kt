package com.solodilov.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {

    companion object {
        private const val END_POINT = "https://api.coingecko.com/api/"
        const val COIN_PER_PAGE = "30"
    }

    suspend fun getCoinList(currency: String) = client.get("${END_POINT}v3/coins/markets?vs_currency=$currency&per_page=$COIN_PER_PAGE")
    suspend fun getCoinDetail(id: String) = client.get("${END_POINT}v3/coins/$id")
}
