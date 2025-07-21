package com.example.skycast.data.remote

import android.util.Log
import com.example.skycast.BuildConfig
import com.example.skycast.data.datasource.remote.entity.ForecastDto
import com.example.skycast.data.datasource.remote.weather.WeatherApi
import javax.inject.Inject

class RemoteWeatherDataSourceImpl @Inject constructor(
    private val weatherApi:WeatherApi
) {

    suspend fun getForecast(city:String):ForecastDto{
        return weatherApi.getForecast(city)
    }
}