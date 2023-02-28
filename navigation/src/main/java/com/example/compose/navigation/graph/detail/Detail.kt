package com.example.compose.navigation.graph.detail

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navDeepLink
import com.example.compose.contact.ContactScreen
import com.example.compose.contact.InitialContactData
import com.example.compose.detial.DetailScreen
import com.example.compose.detial.DetailScreenDeepLinkRoute
import com.example.compose.detial.InitialDetailData
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.extension.parcelableData
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.detail(navController: NavController) {
    navigation(
        route = Destinations.DetailGraph.route,
        startDestination = Destinations.DetailGraph.DetailScreen().route
    ) {
        composable(
            route = Destinations.DetailGraph.DetailScreen().route,
            /*enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { it / 2 },
                    animationSpec = tween(500)
                )
            }*/
        ) { entry ->
            val data =
                entry.parcelableData<InitialDetailData>(Destinations.DetailGraph.DetailScreen().detailData)
            DetailScreen(
                data = data,
                navigator = DetailNavigatorImpl(navController)
            )
        }

        // detail deeplink route
        composable(
            route = Destinations.DetailGraph.DetailScreenFromDeepLink().route,
            deepLinks = listOf(navDeepLink {
                // todo scheme and host of uri should get from build config
                uriPattern =
                    "myapp://myhost.com/detail/{${Destinations.DetailGraph.DetailScreenFromDeepLink().itemId}}"
            })
        ) { entry ->
            val itemId =
                entry.arguments?.getString(Destinations.DetailGraph.DetailScreenFromDeepLink().itemId)
            DetailScreenDeepLinkRoute(
                itemId = itemId,
                navigator = DetailNavigatorImpl(navController)
            )
        }

        // contact
        composable(route = Destinations.DetailGraph.ContactScreen().route) { entry ->
            val data =
                entry.parcelableData<InitialContactData>(Destinations.DetailGraph.ContactScreen().contactData)
            ContactScreen(data = data, navigator = ContactNavigatorImpl(navController))
        }
    }
}
