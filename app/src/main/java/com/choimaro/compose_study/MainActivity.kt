package com.choimaro.compose_study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.choimaro.compose_study.home.HomeScreen
import com.choimaro.compose_study.login.LoginScreen
import com.choimaro.compose_study.ui.theme.ComposestudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposestudyTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                val navController = rememberNavController()
                val routeAction = remember(navController) { RouteAction(navController) }
                NavHost(
                    navController = navController,
                    startDestination = ScreenType.LoginPage.route) {

                    composable(route = ScreenType.LoginPage.route) {
                        LoginScreen(routeAction)
                    }
                    composable(route = ScreenType.HomePage.route) {
                        HomeScreen(routeAction)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposestudyTheme {
        Greeting("Android")
    }
}