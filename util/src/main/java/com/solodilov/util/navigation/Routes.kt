package com.solodilov.util.navigation

object Routes {
    const val CoinList = "CoinList"
    const val CoinDetails = "${Destinations.CoinDetailsScreen}/{${Arguments.CoinId}}/{${Arguments.CoinName}}"
}

object Arguments {
    const val CoinId = "CoinId"
    const val CoinName = "CoinName"
}

object Destinations {
    const val CoinDetailsScreen = "CoinDetailsScreen"
}