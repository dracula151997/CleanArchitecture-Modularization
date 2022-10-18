package com.dracula.presentation_common.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

private const val ROUTE_USER = "users/%s"
private const val ARGS_USER_ID = "userId"

sealed class NavRoute(
    val route: String,
    val args: List<NamedNavArgument> = emptyList()
) {
    object UserRoue : NavRoute(
        route = String.format(ROUTE_USER, ARGS_USER_ID),
        args = listOf(
            navArgument(ARGS_USER_ID) { type = NavType.LongType }
        )
    ) {
        fun routeForUserScreen(userInput: UserInput) = String.format(ROUTE_USER, userInput.userId)

        fun fromEntry(entry: NavBackStackEntry): UserInput {
            return UserInput(entry.arguments?.getLong(ARGS_USER_ID) ?: 0L)
        }

    }
}