package com.example.compose.favorite

import com.example.compose.base.BottomBarNavigator
import com.example.compose.detial.InitialDetailData

interface FavoriteNavigator : BottomBarNavigator {
    fun navigateToDetail(data: InitialDetailData)
}
