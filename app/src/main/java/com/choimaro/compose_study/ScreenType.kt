package com.choimaro.compose_study

sealed class ScreenType(val route: String) {
    object SplashScreen : ScreenType(route = "splash_screen")
    object HomePage : ScreenType(route = "home_screen")
    object LoginPage : ScreenType(route = "login_screen")
}