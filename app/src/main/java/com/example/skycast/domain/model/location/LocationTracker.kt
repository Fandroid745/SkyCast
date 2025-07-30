package com.example.skycast.domain.model.location

import android.location.Location


interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}
