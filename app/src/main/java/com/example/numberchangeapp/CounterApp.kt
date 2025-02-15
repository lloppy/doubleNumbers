package com.example.numberchangeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun CounterApp() {
    val navController = rememberNavController()
    var counter by rememberSaveable { mutableIntStateOf(0) }

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                counter = counter,
                onCounterIncreased = { counter++ },
                onNavigateToSecondScreen = {
                    navController.navigate("second/$counter")
                }
            )
        }
        composable("second/{counterValue}") { backStackEntry ->
            val counterValue =
                backStackEntry.arguments?.getString("counterValue")?.toIntOrNull() ?: 0
            SecondScreen(squaredValue = counterValue * counterValue)
        }
    }
}