package com.triplefarmer.fullbat.controller

import android.content.Context
import android.util.Log
import androidx.navigation.NavController
import com.triplefarmer.fullbat.data.LoginSharedPreferences
import com.triplefarmer.fullbat.nav.ScreenRoute

class SigninController() {
    fun login(navController: NavController, context: Context, id: String) {
        LoginSharedPreferences(context).loginId = id
        Log.d("login", LoginSharedPreferences(context).loginId.toString())

        navController.navigate(ScreenRoute.MAIN.route)
    }
}