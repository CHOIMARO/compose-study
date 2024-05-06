package com.choimaro.compose_study

sealed class ScreenType(val route: String) {
    object IntroScreen : ScreenType(route = "intro_screen")
    object HomePage : ScreenType(route = "home_screen")
    object LoginPage : ScreenType(route = "login_screen")
}