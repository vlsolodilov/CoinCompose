package com.solodilov.util.navigation

object Routes {
    const val CoinList = "CoinList"
    const val CoinDetails = "${Destinations.CoinDetailsScreen}/{${Arguments.CoinId}}"
}

object Arguments {
    const val CoinId = "CoinId"
}

object Destinations {
    const val CoinDetailsScreen = "CoinDetailsScreen"
}