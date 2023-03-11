package com.example.compose.navigation.graph.detail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.example.compose.contact.ContactScreen
import com.example.compose.contact.InitialContactData
import com.example.compose.detial.DetailScreen
import com.example.compose.detial.DetailScreenDeepLinkRoute
import com.example.compose.detial.InitialDetailData
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.extension.isCurrentDestinationRoute
import com.example.compose.navigation.extension.parcelableData

fun NavGraphBuilder.detail(navController: NavController) {
    navigation(
        route = Destinations.DetailGraph.route,
        startDestination = Destinations.DetailGraph.DetailScreen.route
    ) {
        composable(
            route = Destinations.DetailGraph.DetailScreen.route
        ) { entry ->
            if (entry.isCurrentDestinationRoute(navController)) {
                val data =
                    entry.parcelableData<InitialDetailData>(Destinations.DetailGraph.DetailScreen.detailDataKey)
                DetailScreen(
                    data = data,
                    navigator = DetailNavigatorImpl(navController)
                )
            }
        }

        composable(
            route = Destinations.DetailGraph.DetailScreenFromDeepLink.route,
            deepLinks = listOf(navDeepLink {
                // todo scheme and host of uri should get from build config
                uriPattern =
                    "myapp://myhost.com/detail/{${Destinations.DetailGraph.DetailScreenFromDeepLink.itemIdKey}}"
            })
        ) { entry ->
            if (entry.isCurrentDestinationRoute(navController)) {
                val itemId =
                    entry.arguments?.getString(Destinations.DetailGraph.DetailScreenFromDeepLink.itemIdKey)
                DetailScreenDeepLinkRoute(
                    itemId = itemId,
                    navigator = DetailNavigatorImpl(navController)
                )
            }
        }

        composable(route = Destinations.DetailGraph.ContactScreen.route) { entry ->
            if (entry.isCurrentDestinationRoute(navController)) {
                val data =
                    entry.parcelableData<InitialContactData>(Destinations.DetailGraph.ContactScreen.contactDataKey)
                ContactScreen(data = data, navigator = ContactNavigatorImpl(navController))
            }
        }
    }
}
