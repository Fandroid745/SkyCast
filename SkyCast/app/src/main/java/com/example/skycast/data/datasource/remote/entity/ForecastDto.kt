package com.example.skycast.data.datasource.remote.entity

import com.squareup.moshi.Json

data class ForecastDto(
    @field:Json(name="List")
    val list:List<ForecastItemDao>,

    @field:Json(name="city")
    val city:CityDto
)

data class ForecastItemDao(

    @field:Json(name="dt")
    val timestamp:Long,


    @field:Json(name="main")
    val main:MainDto,


    @field:Json(name="weather")
    val weather:List<WeatherDto>
)


data class MainDto(
    @field:Json(name="temp")
    val temp:Double
)

data class WeatherDto(
    @field:Json(name="description")
    val description:String
)

data class CityDto(
    @field:Json(name="name")
    val name:String
)