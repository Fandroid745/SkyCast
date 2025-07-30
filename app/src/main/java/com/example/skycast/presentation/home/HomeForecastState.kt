package com.example.skycast.presentation.home

import com.example.skycast.domain.model.Forecast

sealed class HomeForecastState {
    object Loading: HomeForecastState()
    data class Success(val forecast: Forecast):HomeForecastState()
    data class Error(val message:String):HomeForecastState()
}

