package com.example.compose.detial

import android.os.Parcelable
import com.example.compose.contact.InitialContactData
import kotlinx.parcelize.Parcelize

@Parcelize
data class InitialDetailData(val title:String, val content:String, val isFromDeeplink:Boolean = false) : Parcelable
fun InitialDetailData.toContactData() = InitialContactData(title)
