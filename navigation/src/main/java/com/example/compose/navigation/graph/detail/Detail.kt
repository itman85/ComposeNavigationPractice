package com.example.compose.navigation.graph.detail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.compose.contact.ContactScreen
import com.example.compose.contact.InitialContactData
import com.example.compose.detial.DetailScreen
import com.example.compose.detial.InitialDetailData
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.extension.parcelableData

fun NavGraphBuilder.detail(navController: NavController) {
    navigation(
        route = Destinations.DetailGraph.route,
        startDestination = Destinations.DetailGraph.DetailScreen().route
    ) {
        composable(
            route = Destinations.DetailGraph.DetailScreen().route
        ) { entry ->
            val data =
                entry.parcelableData<InitialDetailData>(Destinations.DetailGraph.DetailScreen().detailData)
            DetailScreen(data = data, navigator = DetailNavigatorImpl(navController))
        }
        composable(route = Destinations.DetailGraph.ContactScreen().route) { entry ->
            val data =
                entry.parcelableData<InitialContactData>(Destinations.DetailGraph.ContactScreen().contactData)
            ContactScreen(data = data, navigator = ContactNavigatorImpl(navController))
        }
    }
}
