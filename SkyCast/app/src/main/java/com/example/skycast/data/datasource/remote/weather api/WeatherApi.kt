package com.example.skycast.data.datasource.remote.weather

import com.example.skycast.BuildConfig
import com.example.skycast.data.datasource.remote.entity.ForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi{
    @GET("forecast")
    suspend fun getForecast(
        @Query("q") cityname:String,
        @Query("appid") apiKey:String= BuildConfig.WEATHER_API_KEY,
        @Query("units") units:String="metric"
    ): ForecastDto
}

