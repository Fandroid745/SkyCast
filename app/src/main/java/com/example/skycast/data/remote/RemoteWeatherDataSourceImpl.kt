package com.example.skycast.data.remote

import com.example.skycast.data.datasource.remote.entity.ForecastDto
import com.example.skycast.data.datasource.remote.weather.WeatherApi
import javax.inject.Inject

class RemoteWeatherDataSourceImpl @Inject constructor(
    private val weatherApi: WeatherApi
) {
    suspend fun getForecast(lat: Double, lon: Double): ForecastDto {
        return weatherApi.getForecast(lat, lon)
    }
}
