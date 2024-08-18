package com.solodilov.coincompose.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.solodilov.coin.screen.coin_detail.CoinDetailsScreen
import com.solodilov.coin.screen.coin_list.ui.CoinListScreen
import com.solodilov.util.navigation.Arguments
import com.solodilov.util.navigation.Routes

@Composable
fun NavGraph(
    padding: PaddingValues,
) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    val animationSpec: FiniteAnimationSpec<IntOffset> = tween(400)

    NavHost(
        modifier = Modifier.padding(padding),
        navController = navController,
        startDestination = Routes.CoinList
    ) {

        composable(
            route = Routes.CoinList,
            enterTransition = {
                when (initialState.destination.route) {
                    Routes.CoinDetails -> slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec
                    )

                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Routes.CoinDetails -> slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec
                    )

                    else -> null
                }
            },
        ) {
            CoinListScreen(navigateWithArgument = actions.navigateWithArgument)
        }
        composable(
            route = Routes.CoinDetails,
            arguments = listOf(navArgument(Arguments.CoinId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            CoinDetailsScreen(
                coinId = arguments.getString(Arguments.CoinId, ""),
                navigateTo = actions.navigateTo,
            )
        }
    }
}