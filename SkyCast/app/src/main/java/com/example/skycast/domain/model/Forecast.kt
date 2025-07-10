package com.example.skycast.domain.model

data class Forecast(
    val cityName:String,
    val temperature:Double,
    val description:String,
    val timeStamp:Long
)