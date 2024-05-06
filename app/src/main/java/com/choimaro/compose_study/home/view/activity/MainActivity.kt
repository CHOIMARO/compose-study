package com.choimaro.compose_study.home.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.choimaro.compose_study.ScreenType
import com.choimaro.compose_study.home.view.screen.HomeScreen
import com.choimaro.compose_study.login.view.screen.LoginScreen
import com.choimaro.compose_study.ui.theme.ComposestudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
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
                NavHost(
                    navController = navController,
                    startDestination = ScreenType.LoginPage.route) {

                    composable(route = ScreenType.LoginPage.route) {
                        LoginScreen(navController)
                    }
                    composable(route = ScreenType.HomePage.route) {
                        HomeScreen(navController)
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