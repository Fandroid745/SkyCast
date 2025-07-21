package com.example.skycast.presentation.navigation

sealed class NavScreen(val route:String) {
    object Home: NavScreen("home")
}