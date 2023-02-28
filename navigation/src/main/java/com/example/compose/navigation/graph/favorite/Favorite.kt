package com.example.compose.navigation.graph.favorite

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.compose.favorite.FavoriteScreen
import com.example.compose.navigation.Destinations
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.favorite(navController: NavController) {
    composable(route = Destinations.FavoriteScreen.route) {
        FavoriteScreen(navigator = FavoriteNavigatorImpl(navController))
    }
}
