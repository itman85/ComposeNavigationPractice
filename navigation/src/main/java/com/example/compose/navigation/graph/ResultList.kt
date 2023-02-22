package com.example.compose.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.compose.navigation.Destinations

fun NavGraphBuilder.resultList(
    navController: NavController
){
    composable(route = Destinations.ResultListScreen.route){

    }
}
