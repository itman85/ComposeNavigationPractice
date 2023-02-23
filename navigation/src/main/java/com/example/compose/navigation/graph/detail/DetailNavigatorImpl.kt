package com.example.compose.navigation.graph.detail

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.compose.contact.InitialContactData
import com.example.compose.detial.DetailNavigator
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.extension.navigateTo

// todo DI?
class DetailNavigatorImpl(private val navController: NavController): DetailNavigator {
    override fun navigateToContact(data: InitialContactData) {
        navController.navigateTo(
            route = Destinations.DetailGraph.ContactScreen().route,
            args = bundleOf(Destinations.DetailGraph.ContactScreen().contactData to data)
        )
    }

    override fun navigateBack() {
        navController.navigateUp()
    }
}
