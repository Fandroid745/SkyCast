package com.example.skycast.domain.repository


import com.example.skycast.domain.model.Forecast
import com.example.skycast.domain.util.Resource

interface ForecastRepository{
    suspend fun getForecast(lat:Double,lon:Double): Resource<Forecast>
}