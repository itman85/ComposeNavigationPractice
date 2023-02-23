package com.example.compose.resultlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultListScreen(navigator:ResultListNavigator) {
    val itemsList = createResultDataList()
    LazyColumn {
        items(items = itemsList){item ->
            Row(modifier = Modifier.padding(8.dp).clickable {
                navigator.navigateToDetail(item.mapToDetail())
            }) {
                Text(text = item.title)
                Text(text = item.content)
            }
        }
    }
}

private fun createResultDataList():List<ResultData>{
    return (0..10).map {
        ResultData(title = "title ${it+1}", content = "Content for item ${it+1}")
    }
}
