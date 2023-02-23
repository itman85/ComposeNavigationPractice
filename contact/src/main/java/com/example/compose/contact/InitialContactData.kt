package com.example.compose.contact

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InitialContactData(val title:String) : Parcelable
