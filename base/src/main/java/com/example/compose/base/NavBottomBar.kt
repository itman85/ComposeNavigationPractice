package com.example.compose.base

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavigationBar(
    currentItemType: ItemType,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    BottomNavigation(
        modifier = modifier,
        elevation = 5.dp
    ) {
        itemsList.forEach { item ->
            val selected = item.itemType == currentItemType
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                icon = {
                    BottomNavigationIcon(
                        name = item.name,
                        icon = item.icon,
                        selected = selected,
                        badgeCount = item.badgeCount,
                    )
                }
            )
        }
    }
}

@Composable
fun BottomNavigationIcon(
    name: String,
    icon: ImageVector,
    selected: Boolean,
    badgeCount: Int,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (badgeCount > 0) {
            BadgedBox(
                badge = {
                    Text(text = badgeCount.toString())
                }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = name
                )
            }
        } else {
            Icon(
                imageVector = icon,
                contentDescription = name
            )
        }
        if (selected) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                fontSize = 10.sp
            )
        }
    }
}

private val itemsList = listOf(
    BottomNavItem(
        name = "Results",
        itemType = ItemType.LIST,
        icon = Icons.Default.Home
    ),
    BottomNavItem(
        name = "Favorite",
        itemType = ItemType.FAVORITE,
        icon = Icons.Default.Favorite,
    ),
)

data class BottomNavItem(
    val name: String,
    val itemType: ItemType,
    val icon: ImageVector,
    val badgeCount: Int = 0,
)

enum class ItemType {
    LIST, FAVORITE
}

interface BottomBarNavigator {
    fun navigateToItemBar(itemType: ItemType)
}
