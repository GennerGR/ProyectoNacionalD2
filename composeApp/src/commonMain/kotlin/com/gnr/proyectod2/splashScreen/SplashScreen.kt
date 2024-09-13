package com.gnr.proyectod2.splashScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.gnr.proyectod2.main.MainScreen
import kotlinx.coroutines.delay

class SplashScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier.fillMaxSize().background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SplashScreenTwoSecond(onTimeOut = {navigator.push(MainScreen()) })
        }
    }

    @Composable
    fun SplashScreenTwoSecond(onTimeOut: () -> Unit) {
        LaunchedEffect(Unit) {
            delay(1500)
            onTimeOut()
        }
        Box(
            modifier = Modifier.fillMaxSize().background(color = Color.White),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
            CircularProgressIndicator(color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Cargando...", fontSize = 15.sp)
        }
    }
}

//Pantalla de carga al iniciar la app