package com.example.skycast.presentation.home

import androidx.lifecycle.ViewModel
import com.example.skycast.domain.usecase.forecast.GetForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase
) : ViewModel(){

}