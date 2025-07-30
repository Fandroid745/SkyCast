package com.example.skycast.data.datasource.remote.weather

import com.example.skycast.BuildConfig
import com.example.skycast.data.datasource.remote.entity.ForecastDto
import com.example.skycast.util.NetworkService
import retrofit2.http.GET
import retrofit2.http.Query



interface WeatherApi {
    @GET("data/2.5/forecast")
    suspend fun getForecast(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("units") units:String="metric",
        @Query("appid")apiKey:String=BuildConfig.WEATHER_API_KEY
    ): ForecastDto
}
