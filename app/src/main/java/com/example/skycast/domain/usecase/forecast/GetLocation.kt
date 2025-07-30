package com.example.skycast.domain.usecase.forecast

import android.location.Location
import com.example.skycast.domain.model.location.LocationTracker
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(
    private val locationTracker: LocationTracker
) {
    suspend operator fun invoke(): Location? {
        return locationTracker.getCurrentLocation()
    }
}