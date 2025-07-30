package com.example.skycast.presentation.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.skycast.domain.usecase.forecast.GetForecastUseCase
import com.example.skycast.domain.usecase.forecast.GetLocationUseCase
import com.example.skycast.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase,
    private val getLocationUseCase: GetLocationUseCase
) : ViewModel() {

    var state = mutableStateOf<HomeForecastState>(HomeForecastState.Loading)
        private set


    fun handlePermissionDenied() {
        state.value=HomeForecastState.Error("Location permission is required to fetch the weather data ")
        Log.w("HomeViewModel", "Location permission denied")
    }


    fun loadForecastForCurrentLocation() {
        state.value = HomeForecastState.Loading

        viewModelScope.launch {
            val location = getLocationUseCase()

            if (location == null) {
                state.value = HomeForecastState.Error("Unable to get location")
                return@launch
            }

            when (val result = getForecastUseCase(location.latitude, location.longitude)) {
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
