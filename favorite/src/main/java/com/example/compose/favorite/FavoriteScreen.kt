package com.example.compose.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteScreen(navigator: FavoriteNavigator) {
    val itemsList = createFavoriteDataList()
    LazyColumn {
        items(items = itemsList){ item ->
            Row (modifier = Modifier.fillMaxSize().padding(8.dp)
                .clickable {
                    navigator.navigateToDetail(item.mapToDetail())
                }){
                Text(text = item.title)
                Text(text = item.content)
                Text(text = item.favoriteNote)
            }
        }
    }
}

private fun createFavoriteDataList():List<FavoriteData>{
    return (0..5).map {
        FavoriteData(title = "title ${it+1}", content = "Content for item ${it+1}", favoriteNote = "Note for item ${it+1}")
    }
}
