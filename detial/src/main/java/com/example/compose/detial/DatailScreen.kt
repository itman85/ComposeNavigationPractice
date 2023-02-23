package com.example.compose.detial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.contact.InitialContactData

@Composable
fun DetailScreen(data: InitialDetailData?, navigator:DetailNavigator) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(data?.title ?: "No data")
        Text(data?.content ?: "No data")
        Text("More Detail Info ...")
        Button(onClick = {navigator.navigateToContact(data?.toContactData() ?: InitialContactData("")) }) {
            Text(text = "Contact")
        }
    }
}
