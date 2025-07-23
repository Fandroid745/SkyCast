package com.example.skycast

import android.os.Bundle
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.skycast.presentation.navigation.NavGraph
import com.example.skycast.ui.theme.SkyCastTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("API_KEY_CHECK", "API key used: ${BuildConfig.WEATHER_API_KEY}")
        setContent {
             Surface (modifier=Modifier.fillMaxSize(),
                 color=MaterialTheme.colorScheme.background
             ) {
            SkyCastTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SkyCastTheme {
        Greeting("Android")
    }
}