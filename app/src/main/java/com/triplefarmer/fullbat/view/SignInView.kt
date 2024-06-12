package com.triplefarmer.fullbat.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.triplefarmer.fullbat.R
import com.triplefarmer.fullbat.controller.SigninController
import com.triplefarmer.fullbat.data.ConstantObj

object SignInView {
    private val controller = SigninController()

    @Composable
    fun screen(navController: NavController, context: Context) {
        val idState = remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            logoImage()
            guideText()
            idTextField(text = idState)
            signInButton(navController, context, idState.value)
        }
    }

    @Composable
    private fun logoImage() {
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
                    .height(92.dp)
                    .width(91.dp)
            )

            Image(
                painter = painterResource(R.drawable.ic_solved_baekjoon),
                contentDescription = ConstantObj.Logo,
                modifier = Modifier
                    .height(47.dp)
                    .width(168.dp)
            )
        }

    }

    @Composable
    private fun guideText() {
        Text (
            text = ConstantObj.InputId,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 21.dp)
        )
    }
    
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun idTextField(text: MutableState<String>) {
        TextField(
            value = text.value,
            onValueChange = { text.value = it},
            modifier = Modifier
                .padding(bottom = 36.dp)
        )
    }

    @Composable
    private fun signInButton(navController: NavController, context: Context, id: String) {
        Button(onClick = {
            controller.login(navController, context, id,)

        }) {
            Text(text = ConstantObj.Login)
        }
    }
}