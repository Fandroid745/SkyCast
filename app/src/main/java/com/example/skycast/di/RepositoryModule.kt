package com.example.skycast.di

import com.example.skycast.data.repository.ForecastRepositoryImpl
import com.example.skycast.domain.repository.ForecastRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds  // ← This tells Hilt: "When someone asks for ForecastRepository..."
    @Singleton
    abstract fun bindForecastRepository(
        forecastRepositoryImpl: ForecastRepositoryImpl  // ← "...give them this implementation"
    ): ForecastRepository
}