package com.example.skycast.data.mapper


import com.example.skycast.data.datasource.remote.entity.ForecastDto
import com.example.skycast.domain.model.Forecast
import javax.inject.Inject

class ForecastDtoMapper @Inject constructor() {
    fun mapFromDto(dto: ForecastDto):Forecast{
        return Forecast(
            cityName=dto.city.name,
            temperature=dto.list[0].main.temp,
            description=dto.list[0].weather.first().description,
            timeStamp=dto.list[0].timestamp
        )
    }
}