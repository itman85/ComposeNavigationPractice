package com.example.compose.detial

import com.example.compose.contact.InitialContactData

interface DetailNavigator {
    fun navigateToContact(data: InitialContactData)
    fun navigateBack()
    fun navigateBackFromDeeplink()
    fun navigateToSimilarItem(data: InitialDetailData)
}
