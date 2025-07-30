package com.example.skycast.util
import com.example.skycast.BuildConfig


object NetworkService {

    const val BASE_URL = "https://api.openweathermap.org"
    const val API_KEY = BuildConfig.WEATHER_API_KEY
    const val UNITS = "metric"
    const val FORECAST_END_POINT = "/data/2.5/forecast"


    fun buildForecastUrl(lat: Double, lon: Double): String {
        return "$BASE_URL$FORECAST_END_POINT?lat=$lat&lon=$lon&appid=$API_KEY&units=$UNITS"
    }


    fun buildForecastUrl(cityName: String): String {
        return "$BASE_URL$FORECAST_END_POINT?q=$cityName&appid=$API_KEY&units=$UNITS"
    }
}