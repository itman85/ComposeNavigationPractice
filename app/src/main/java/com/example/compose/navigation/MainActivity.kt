package com.example.compose.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose.navigation.graph.detail.detail
import com.example.compose.navigation.graph.favorite.favorite
import com.example.compose.navigation.graph.resultlist.resultList
import com.example.compose.navigation.ui.theme.ComposeNavigationPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationPracticeTheme {
                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()
                val currentScreenRoute = backStackEntry.value?.destination?.route
                val bottomNavVisible = items.any {
                    it.route == currentScreenRoute
                }
                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(visible = bottomNavVisible,
                            enter = slideInVertically { it },
                            exit = slideOutVertically { it }) {
                            BottomNavigationBar(
                                items = items,
                                currentScreenRoute = currentScreenRoute
                            ) {
                                navController.navigate(it.route)
                            }

                        }
                    }
                ) { paddingValues ->
                    AppNavHost(
                        navController = navController,
                        activity = this,
                        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController, activity: MainActivity, modifier: Modifier) {

    NavHost(
        navController = navController,
        startDestination = Destinations.ResultListScreen.route,
        modifier = modifier
    ) {
        resultList(navController, activity)
        favorite(navController)
        detail(navController)
    }

}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    currentScreenRoute: String?,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    BottomNavigation(
        modifier = modifier,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == currentScreenRoute
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

private val items = listOf(
    BottomNavItem(
        name = "Results",
        route = Destinations.ResultListScreen.route,
        icon = Icons.Default.Home
    ),
    BottomNavItem(
        name = "Favorite",
        route = Destinations.FavoriteScreen.route,
        icon = Icons.Default.Favorite,
    ),
)

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
)

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNavigationPracticeTheme {
        Greeting("Android")
    }
}
