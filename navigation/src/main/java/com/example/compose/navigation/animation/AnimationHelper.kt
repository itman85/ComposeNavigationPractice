package com.example.compose.navigation.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable

@Composable
fun screenTransitionAnimation(
    isVisible: Boolean,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = tween(durationMillis = 500)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { it },
            animationSpec = tween(durationMillis = 500)
        ),

        //enter = slideInHorizontally(initialOffsetX = { it }),
        //exit = slideOutHorizontally(targetOffsetX = { it }),
        content = content
    )
}
