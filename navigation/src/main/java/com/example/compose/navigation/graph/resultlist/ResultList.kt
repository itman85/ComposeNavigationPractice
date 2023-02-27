package com.example.compose.navigation.graph.resultlist

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.extension.isCurrentDestinationRoute
import com.example.compose.resultlist.ResultListScreen

fun NavGraphBuilder.resultList(navController: NavController,activity: Activity) {
    composable(route = Destinations.ResultListScreen.route) {
        // this will prevent recompose as navigate to other destinations
        if (it.isCurrentDestinationRoute(navController)) {
            ResultListScreen(navigator = ResultListNavigatorImpl(navController,activity))
        }
    }
}

