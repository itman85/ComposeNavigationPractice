package com.example.compose.contact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContactScreen(data: InitialContactData?) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(data?.title ?: "no data")
        Text("More Contact Info ...")
    }
}
