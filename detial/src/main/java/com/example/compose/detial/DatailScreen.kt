package com.example.compose.detial

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.compose.contact.InitialContactData

@Composable
fun DetailScreen(data: InitialDetailData?, navigator: DetailNavigator) {

    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Log.d("Phan", "Recompose $count")
    LaunchedEffect(count) {
        Log.d("Phan", "Detail Screen created")
    }
    DisposableEffect(Unit) {
        onDispose {
            Log.d("Phan", "Detail Screen disposed")
        }
    }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Detail Screen") },
            backgroundColor = Color.Gray,
            navigationIcon = {
                IconButton(onClick = { navigator.navigateBack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "detail back")
                }
            }
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(data?.title ?: "No data")
            Text(data?.content ?: "No data")
            Text("More Detail Info ...")
            Button(onClick = { count++ }) {
                Text(text = "Count $count")
            }
            CountdownComponent()
            Button(onClick = {
                navigator.navigateToContact(
                    data?.toContactData() ?: InitialContactData("")
                )
            }) {
                Text(text = "Open Contact")
            }
        }
    }

}

@Composable
fun CountdownComponent() {
    Log.d("Phan", "******Recompose********")
    val lifecycleOwner = LocalLifecycleOwner.current
    var isStopped by remember {
        mutableStateOf(
            lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED).not()
        )
    }
    var timeLeft by remember { mutableStateOf(100L) } // Set initial time left to 10 seconds
    var isRunning by remember { mutableStateOf(false) } // Set initial running state to false
    // this count down timer will start as click on start button, and get cancelled as activity stopped or this composable is disposed
    val countDownTimer = object : CountDownTimer(timeLeft * 1000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            // Update the time left every second
            timeLeft = millisUntilFinished / 1000
            Log.d("Phan", "Countdown stick $timeLeft")
        }

        override fun onFinish() {
            isRunning = false
        }
    }
    if (!isRunning) {
        // Show a button to start the countdown
        Button(onClick = {
            isRunning = true
            countDownTimer.start()
        }) {
            Text(text = "Start Countdown")
        }
    } else {
        // Show the countdown timer
        Text(text = "Time left: $timeLeft seconds")
    }
    DisposableEffect(Unit) {
        val lifecycle = lifecycleOwner.lifecycle
        val observer = LifecycleEventObserver { _, event ->
            Log.d("Phan", "Event $event")
            if (event == Lifecycle.Event.ON_STOP) {
                isStopped = true
                countDownTimer.cancel() // cancel as activity stopped
            } else if (event == Lifecycle.Event.ON_START) {
                isStopped = false
            }
        }
        lifecycle.addObserver(observer)
        onDispose {
            countDownTimer.cancel() // cancel as this composable disposed
            lifecycle.removeObserver(observer)
        }
    }
}
