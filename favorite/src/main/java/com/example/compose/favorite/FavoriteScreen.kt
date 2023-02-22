package com.example.compose.favorite

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun FavoriteScreen() {
    val itemsList = listOf<FavoriteData>()
    LazyColumn {
        items(items = itemsList){
            Row {
                Text(text = it.title)
                Text(text = it.content)
                Text(text = it.favoriteNote)
            }
        }
    }
}
