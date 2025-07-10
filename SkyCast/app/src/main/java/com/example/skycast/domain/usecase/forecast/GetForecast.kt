package com.example.skycast.domain.usecase.forecast

import com.example.skycast.domain.model.Forecast
import com.example.skycast.domain.util.Resource
import javax.inject.Inject

class GetForecastUseCase @Inject constructor (
    private val repository:ForecastRepository
) {
    suspend operator fun invoke(city:String): Resource<Forecast> {
        return repository.getForecast(city)
    }
}
