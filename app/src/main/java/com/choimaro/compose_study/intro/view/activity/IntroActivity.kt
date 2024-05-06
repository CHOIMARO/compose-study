package com.choimaro.compose_study.intro.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.choimaro.compose_study.ScreenType
import com.choimaro.compose_study.home.view.screen.HomeScreen
import com.choimaro.compose_study.login.view.screen.LoginScreen
import com.choimaro.compose_study.intro.view.activity.ui.theme.ComposestudyTheme
import com.choimaro.compose_study.intro.view.screen.IntroScreen
import com.choimaro.compose_study.intro.viewmodel.IntroViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class IntroActivity : ComponentActivity() {
    private val introViewModel by viewModels<IntroViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ComposestudyTheme {
                NavHost(
                    navController = navController,
                    startDestination = ScreenType.IntroScreen.route) {
                    composable(route = ScreenType.IntroScreen.route) {
                        IntroScreen(navController)
                    }
                    composable(route = ScreenType.LoginPage.route) {
                        LoginScreen(navController)
                    }
                    composable(route = ScreenType.HomePage.route) {
                        HomeScreen(navController)
                    }
                }
            }
            LaunchedEffect(key1 = introViewModel.isReady) {
                launch {
                    introViewModel.isReady.collectLatest {state ->
                        if (state) {
                            navController.navigate(ScreenType.LoginPage.route)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ComposestudyTheme {
        Greeting2("Android")
    }
}