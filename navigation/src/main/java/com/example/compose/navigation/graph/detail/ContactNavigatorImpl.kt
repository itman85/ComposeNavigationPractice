package com.example.compose.navigation.graph.detail

import androidx.navigation.NavController
import com.example.compose.contact.ContactNavigator

class ContactNavigatorImpl(private val navController: NavController) : ContactNavigator {
    override fun navigateBack() {
        navController.navigateUp()
    }
}
