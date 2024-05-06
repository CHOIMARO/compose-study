package com.choimaro.compose_study.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.choimaro.compose_study.RouteAction
import com.choimaro.compose_study.ScreenType

@Composable
fun HomeScreen(routeAction: RouteAction) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Column {
            Text(text = "홈 화면")
            Button(onClick = { routeAction.goBack }) {
                
            }
        }
        
    }
}