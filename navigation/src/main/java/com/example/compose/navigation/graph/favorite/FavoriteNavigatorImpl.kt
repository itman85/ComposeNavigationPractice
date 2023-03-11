package com.example.compose.navigation.graph.favorite

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.compose.detial.InitialDetailData
import com.example.compose.favorite.FavoriteNavigator
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.extension.navigateTo

class FavoriteNavigatorImpl(private val navController: NavController): FavoriteNavigator {
    override fun navigateToDetail(data: InitialDetailData) {
        navController.navigateTo(
            route = Destinations.DetailGraph.route,
            args = bundleOf(Destinations.DetailGraph.DetailScreen.detailDataKey to data)
        )
    }
}
