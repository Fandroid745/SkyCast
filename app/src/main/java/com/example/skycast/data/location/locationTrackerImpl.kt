package com.example.skycast.data.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.example.skycast.domain.model.location.LocationTracker
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class LocationTrackerImpl @Inject constructor(
    @ApplicationContext private val context:Context
):LocationTracker{
    private val fusedLocationClient= LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(): Location? {
        return suspendCoroutine { continutation->
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location->
                    continutation.resume(location)
                }

                .addOnFailureListener{
                    continutation.resume(null)
                }
        }
    }
}
