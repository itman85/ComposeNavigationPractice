package com.example.compose.navigation.graph.resultlist

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.compose.favorite.FavoriteScreen
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.graph.favorite.FavoriteNavigatorImpl
import com.example.compose.resultlist.ResultListScreen

fun NavGraphBuilder.resultList(navController: NavController) {
    composable(route = Destinations.ResultListScreen.route) {
        ResultListScreen(navigator = ResultListNavigatorImpl(navController))
    }
}

