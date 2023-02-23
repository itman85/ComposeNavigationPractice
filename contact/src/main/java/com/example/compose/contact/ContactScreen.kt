package com.example.compose.contact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ContactScreen(data: InitialContactData?, navigator: ContactNavigator) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Contact Screen") },
            backgroundColor = Color.Gray,
            navigationIcon = {
                IconButton(onClick = { navigator.navigateBack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "contact back")
                }
            }
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(data?.title ?: "no data")
            Text("More Contact Info ...")
        }
    }
}
