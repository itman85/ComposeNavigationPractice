package com.example.compose.navigation.graph.resultlist

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.compose.detial.InitialDetailData
import com.example.compose.navigation.Destinations
import com.example.compose.navigation.extension.navigateTo
import com.example.compose.resultlist.ResultListNavigator

class ResultListNavigatorImpl(private val navController: NavController): ResultListNavigator {
    override fun navigateToDetail(data: InitialDetailData) {
        navController.navigateTo(
            route = Destinations.DetailGraph.route,
            args = bundleOf(Destinations.DetailGraph.DetailScreen().detailData to data)
        )
    }
}
