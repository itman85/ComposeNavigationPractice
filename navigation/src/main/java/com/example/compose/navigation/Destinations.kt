package com.example.compose.navigation

sealed class Destinations(val route:String) {
    object ResultListScreen: Destinations("resultList")
    object FavoriteScreen: Destinations("favorite")
    data class DetailScreen(val detailData: String = "detailData") : Destinations("detail")
    data class ContactScreen(val contactData: String = "contactData") : Destinations("contact")
}