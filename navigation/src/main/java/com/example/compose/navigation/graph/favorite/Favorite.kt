package com.example.compose.navigation.graph.favorite

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.compose.favorite.FavoriteScreen
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.graph.favorite.FavoriteNavigatorImpl

fun NavGraphBuilder.favorite(navController: NavController) {
    composable(route = Destinations.FavoriteScreen.route) {
        FavoriteScreen(navigator = FavoriteNavigatorImpl(navController))
    }
}
