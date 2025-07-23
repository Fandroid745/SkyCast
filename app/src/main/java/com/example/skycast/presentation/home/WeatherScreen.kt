package com.example.skycast.presentation.home

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WeatherScreen(
    viewmodel:HomeViewModel=hiltViewModel()
) {
    val state= viewmodel.state.collectAsState().value

    when{
        state.isLoading->CircularProgressIndicator()
        state.error!=null ->Text("Error:${state.error}")
        state.weather!=null->{
            WeatherContent(
                weather=state.weatherData
            )
        }
    }
}