package com.example.compose.detial

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(data: InitialDetailData) {
    Column {
        Text(data.title)
        Text(data.content)
        Text("More Detail Info ...")
    }
}
