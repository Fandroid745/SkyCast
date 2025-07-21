package com.example.skycast.data.datasource.remote

import com.example.skycast.data.datasource.remote.entity.ForecastDto
import com.example.skycast.data.datasource.remote.weather.WeatherApi
import javax.inject.Inject

class ForecastRemoteDataSource @Inject constructor(
    private val api:WeatherApi
)
{
    suspend fun getForecast(city:String): ForecastDto {
            return api.getForecast(city)

    }
}