package com.example.compose.resultlist

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ResultListScreen() {
    val itemsList = listOf<ResultData>()
    LazyColumn {
        items(items = itemsList){
            Row {
                Text(text = it.title)
                Text(text = it.content)
            }
        }
    }
}
