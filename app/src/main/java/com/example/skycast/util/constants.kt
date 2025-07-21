package com.example.skycast.util
import com.example.skycast.BuildConfig


object NetworkService {
    // Remove the trailing space from the URL
    const val BASE_URL = "https://api.openweathermap.org"  // Remove any trailing spaces!
    const val API_KEY = BuildConfig.WEATHER_API_KEY
    const val UNITS = "metric"
    const val FORECAST_END_POINT = "/data/2.5/forecast"

    // Helper function to build complete URL with parameters
    fun buildForecastUrl(lat: Double, lon: Double): String {
        return "$BASE_URL$FORECAST_END_POINT?lat=$lat&lon=$lon&appid=$API_KEY&units=$UNITS"
    }

    // Alternative for city name
    fun buildForecastUrl(cityName: String): String {
        return "$BASE_URL$FORECAST_END_POINT?q=$cityName&appid=$API_KEY&units=$UNITS"
    }
}