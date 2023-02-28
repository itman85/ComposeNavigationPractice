package com.example.compose.resultlist

import com.example.compose.base.BottomBarNavigator
import com.example.compose.detial.InitialDetailData

interface ResultListNavigator: BottomBarNavigator {
    fun navigateToDetail(data:InitialDetailData)
    fun navigateBack()
}
