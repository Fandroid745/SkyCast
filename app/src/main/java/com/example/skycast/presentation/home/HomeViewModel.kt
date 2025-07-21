package com.example.skycast.presentation.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skycast.BuildConfig
import com.example.skycast.domain.usecase.forecast.GetForecastUseCase
import com.example.skycast.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase
) : ViewModel() {

    var state = mutableStateOf<HomeForecastState>(HomeForecastState.Loading)
        private set

    fun loadForecast(city: String) {
        state.value = HomeForecastState.Loading
        Log.d("WeatherAPI", "Using API key: '${BuildConfig.WEATHER_API_KEY}'")
        viewModelScope.launch {
            when (val result = getForecastUseCase(city)) {
                is Resource.Success -> {
                    state.value = HomeForecastState.Success(result.data)
                }
                is Resource.Error -> {
                    state.value = HomeForecastState.Error(result.message)
                }
                else -> Unit
            }
        }
    }
}
