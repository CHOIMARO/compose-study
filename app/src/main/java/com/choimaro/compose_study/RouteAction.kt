package com.choimaro.compose_study

import androidx.navigation.NavHostController

class RouteAction(navHostController: NavHostController) {
    val navTo: (ScreenType) -> Unit = { screenType ->
        navHostController.navigate(screenType.route)
    }
    // 뒤로가기 이동
    val goBack:() -> Unit = {
        navHostController.navigateUp()
    }
}