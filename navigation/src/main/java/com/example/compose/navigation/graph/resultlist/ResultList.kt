package com.example.compose.navigation.graph.resultlist

import android.app.Activity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.extension.isCurrentDestinationRoute
import com.example.compose.resultlist.ResultListScreen
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.resultList(navController: NavController, activity: Activity) {
    composable(route = Destinations.ResultListScreen.route,
       /* enterTransition = {
            if(initialState.destination.route != Destinations.FavoriteScreen.route) {
                slideInHorizontally(
                    initialOffsetX = { -it / 2 },
                    animationSpec = tween(500)
                )
            }else null
        },
        exitTransition = {
            if(targetState.destination.route != Destinations.FavoriteScreen.route) {
                slideOutHorizontally(
                    targetOffsetX = { -it },
                    animationSpec = tween(500)
                )
            }else null
        }*/) {
        // this will prevent recompose as navigate to other destinations
      //  if (it.isCurrentDestinationRoute(navController)) {
            ResultListScreen(navigator = ResultListNavigatorImpl(navController, activity))
       // }
    }
}

