package com.example.compose.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose.navigation.graph.detail.detail
import com.example.compose.navigation.graph.favorite.favorite
import com.example.compose.navigation.graph.resultlist.resultList
import com.example.compose.navigation.ui.theme.ComposeNavigationPracticeTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationPracticeTheme {
                val navController = rememberAnimatedNavController() //rememberNavController()
                //val backStackEntry = navController.currentBackStackEntryAsState()
                //val currentScreenRoute = backStackEntry.value?.destination?.route
                Scaffold { paddingValues ->
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavHost(navController: NavHostController, activity: MainActivity, modifier: Modifier) {
    AnimatedNavHost(
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
