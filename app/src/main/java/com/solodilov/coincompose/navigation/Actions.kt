package com.solodilov.coincompose.navigation

import androidx.navigation.NavHostController

data class Actions(val navController: NavHostController) {

    val navigateTo: (String) -> Unit = { route ->
        if (!navController.popBackStack(route = route, inclusive = false)) {
            navController.navigate(route)
        }
    }

    val navigateWithArgument: (String, String, String) -> Unit = { destination, value1, value2  ->
        val route = "$destination/$value1/$value2"
        if (!navController.popBackStack(route = route, inclusive = false)) {
            navController.navigate(route)
        }
    }
}