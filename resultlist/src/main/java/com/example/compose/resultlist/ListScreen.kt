package com.example.compose.resultlist

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose.base.BottomNavigationBar
import com.example.compose.base.ItemType

@Composable
fun ResultListScreen(navigator: ResultListNavigator) {
    val itemsList = createResultDataList()
    BackPressHandler {
        navigator.navigateBack()
    }
    Scaffold(bottomBar = {
        BottomNavigationBar(currentItemType = ItemType.LIST) {
            if (it.itemType != ItemType.LIST)
                navigator.navigateToItemBar(it.itemType)
        }
    }, backgroundColor = Color.LightGray) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(items = itemsList) { item ->
                Row(modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navigator.navigateToDetail(item.mapToDetail())
                    }) {
                    Text(text = item.title)
                    Text(text = item.content)
                }
            }
        }
    }

}

private fun createResultDataList(): List<ResultData> {
    return (0..10).map {
        ResultData(title = "title ${it + 1}", content = "Content for item ${it + 1}")
    }
}

// this composable will be reused many places, should move to common module
@Composable
fun BackPressHandler(
    backPressedDispatcher: OnBackPressedDispatcher? =
        LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
    onBackPressed: () -> Unit
) {
    val currentOnBackPressed by rememberUpdatedState(newValue = onBackPressed)

    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }

    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher?.addCallback(backCallback)

        onDispose {
            backCallback.remove()
        }
    }
}
