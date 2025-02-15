package com.example.numberchangeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import java.io.FileOutputStream

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logToFile("MainActivity onCreate")

        enableEdgeToEdge()
        setContent {
            CounterApp()
        }
    }

    override fun onStart() {
        super.onStart()
        logToFile("MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        logToFile("MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        logToFile("MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        logToFile("MainActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logToFile("MainActivity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        logToFile("MainActivity onRestart")
    }

    private fun logToFile(message: String) {
        try {
            val file =
                FileOutputStream(applicationContext.getFileStreamPath("lifecycle_log.txt"), true)
            file.write("$message\n".toByteArray())
            file.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

