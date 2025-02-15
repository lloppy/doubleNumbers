package com.example.numberchangeapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainScreen(
    counter: Int,
    onCounterIncreased: () -> Unit,
    onNavigateToSecondScreen: () -> Unit
) {
    val configuration = LocalConfiguration.current
    var currentOrientation by rememberSaveable { mutableIntStateOf(configuration.orientation) }

    LaunchedEffect(configuration) {
        snapshotFlow { configuration.orientation }.collectLatest { newOrientation ->
            if (newOrientation != currentOrientation) {
                currentOrientation = newOrientation
                onCounterIncreased()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Counter: $counter", modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onNavigateToSecondScreen() }) {
            Text(text = "Go to Second Screen")
        }
    }
}
