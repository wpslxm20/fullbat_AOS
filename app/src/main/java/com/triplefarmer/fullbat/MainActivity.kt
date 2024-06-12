package com.triplefarmer.fullbat

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.triplefarmer.fullbat.data.LoginSharedPreferences
import com.triplefarmer.fullbat.nav.ScreenRoute
import com.triplefarmer.fullbat.ui.theme.FullbatTheme
import com.triplefarmer.fullbat.view.MainView
import com.triplefarmer.fullbat.view.SignInView
import com.triplefarmer.fullbat.view.SplashView

class MainActivity : ComponentActivity() {
    private val loginSharedPreferences: LoginSharedPreferences by lazy { LoginSharedPreferences(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FullbatTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    screen(this, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }

    @Composable
    fun screen(context: Context, modifier: Modifier = Modifier) {
        val navController = rememberNavController()

        NavHost(navController = navController,
            startDestination = ScreenRoute.SPLASH.route,
            modifier = modifier
        ) {
            composable(route = ScreenRoute.SPLASH.route) {
                SplashView.screen(navController)
            }
            composable(route = ScreenRoute.CHECK_LOGIN.route) {
                CheckLoginAndNavigate(navController)
            }
            composable(route = ScreenRoute.MAIN.route) {
                MainView.screen(navController)
            }
            composable(route = ScreenRoute.SIGN_IN.route) {
                SignInView.screen(navController, context)
            }
            composable(route = ScreenRoute.SEARCH.route) {

            }
        }
    }

    @Composable
    fun CheckLoginAndNavigate(navController: NavController) {
        val context = LocalContext.current
        val loginSharedPreferences = LoginSharedPreferences(context)
        val isLoggedIn = !loginSharedPreferences.loginId.isNullOrEmpty()

        if (isLoggedIn) {
            navController.navigate(ScreenRoute.MAIN.route) {
                popUpTo(ScreenRoute.SIGN_IN.route) { inclusive = true }
            }
        } else {
            navController.navigate(ScreenRoute.SIGN_IN.route) {
                popUpTo(ScreenRoute.MAIN.route) { inclusive = true }
            }
        }
    }
}