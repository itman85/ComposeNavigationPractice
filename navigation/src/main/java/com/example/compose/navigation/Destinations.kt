package com.example.compose.navigation

sealed class Destinations(val route: String) {
    object ResultListScreen : Destinations("resultList")
    object FavoriteScreen : Destinations("favorite")

    object DetailGraph : Destinations("detail_graph") {
        object DetailScreen : Destinations("detail") {
            const val detailDataKey = "detailData"
        }

        object DetailScreenFromDeepLink : Destinations("detailDeeplink") {
            const val itemIdKey = "itemId"
        }

        object ContactScreen : Destinations("contact") {
            const val contactDataKey = "contactData"
        }
    }
}
