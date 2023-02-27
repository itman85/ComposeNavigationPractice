package com.example.compose.navigation

sealed class Destinations(val route:String) {
    object ResultListScreen: Destinations("resultList")
    object FavoriteScreen: Destinations("favorite")

    object DetailGraph: Destinations("detail_graph") {
        data class DetailScreen(val detailData: String = "detailData") : Destinations("detail")

        data class DetailScreenFromDeepLink(val itemId:String = "itemId") : Destinations("detailDeeplink")
        data class ContactScreen(val contactData: String = "contactData") : Destinations("contact")
    }
}
