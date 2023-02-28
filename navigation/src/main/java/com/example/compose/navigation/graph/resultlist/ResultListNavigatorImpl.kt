package com.example.compose.navigation.graph.resultlist

import android.app.Activity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.compose.base.ItemType
import com.example.compose.detial.InitialDetailData
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.extension.navigateTo
import com.example.compose.resultlist.ResultListNavigator

class ResultListNavigatorImpl(
    private val navController: NavController,
    private val activity: Activity
) : ResultListNavigator {
    override fun navigateToDetail(data: InitialDetailData) {
        navController.navigateTo(
            route = Destinations.DetailGraph.route,
            args = bundleOf(Destinations.DetailGraph.DetailScreen().detailData to data)
        )
    }

    override fun navigateBack() {
        // when click back result list screen, it will exit app
        activity.finishAffinity() // app will go to background
        //activity.finishAndRemoveTask() // app completely removed from background
    }

    override fun navigateToItemBar(itemType: ItemType) {
        when (itemType) {
            ItemType.LIST -> navController.navigateTo(Destinations.ResultListScreen.route)
            ItemType.FAVORITE -> navController.navigateTo(Destinations.FavoriteScreen.route)
        }
    }
}
