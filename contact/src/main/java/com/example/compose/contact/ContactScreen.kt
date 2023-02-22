package com.example.compose.contact

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ContactScreen(data: InitialContactData) {
    Column {
        Text(data.title)
        Text("More Contact Info ...")
    }
}
