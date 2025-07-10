package com.example.skycast.data.repository

import com.example.skycast.data.datasource.remote.ForecastRemoteDataSource
import com.example.skycast.data.mapper.ForecastDtoMapper
import com.example.skycast.domain.model.Forecast
import com.example.skycast.domain.repository.ForecastRepository
import com.example.skycast.domain.util.Resource
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(
    private val remoteDataSource: ForecastRemoteDataSource,
    private val mapper: ForecastDtoMapper
) : ForecastRepository {

    override suspend fun getForecast(city: String): Resource<Forecast> {
        return try {
            val dto = remoteDataSource.getForecast(city)
            val forecast = mapper.mapFromDto(dto)
            Resource.Success(forecast)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }
}
