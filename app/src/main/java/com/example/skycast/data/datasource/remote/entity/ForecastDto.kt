package com.example.skycast.data.datasource.remote.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastDto(
    @Json(name = "list")
    val list: List<ForecastItemDao>,

    @Json(name = "city")
    val city: CityDto
)

@JsonClass(generateAdapter = true)
data class ForecastItemDao(
    @Json(name = "dt")
    val timestamp: Long,

    @Json(name = "main")
    val main: MainDto,

    @Json(name = "weather")
    val weather: List<WeatherDto>
)

@JsonClass(generateAdapter = true)
data class MainDto(
    @Json(name = "temp")
    val temp: Double
)

@JsonClass(generateAdapter = true)
data class WeatherDto(
    @Json(name = "description")
    val description: String
)

@JsonClass(generateAdapter = true)
data class CityDto(
    @Json(name = "name")
    val name: String
)
