package com.triplefarmer.fullbat.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.triplefarmer.fullbat.R
import com.triplefarmer.fullbat.data.ConstantObj
import com.triplefarmer.fullbat.nav.ScreenRoute
import kotlinx.coroutines.delay

object SplashView {
    @Composable
    fun screen(navController: NavHostController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            splashImage()
            LaunchedEffect(key1 = true) {
                delay(1000)
                navController.navigate(ScreenRoute.CHECK_LOGIN.route)
            }
        }
    }

    @Composable
    private fun splashImage() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 37.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(R.drawable.ic_fullbat),
                contentDescription = ConstantObj.Logo,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}