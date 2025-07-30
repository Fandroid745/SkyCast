package com.example.skycast.domain.usecase.forecast

import com.example.skycast.domain.model.Forecast
import com.example.skycast.domain.repository.ForecastRepository
import com.example.skycast.domain.util.Resource
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val repository: ForecastRepository
) {
    suspend operator fun invoke(lat: Double, long: Double): Resource<Forecast> {
        return repository.getForecast(lat, long)
    }
}
