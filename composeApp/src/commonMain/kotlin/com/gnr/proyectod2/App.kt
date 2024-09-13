package com.gnr.proyectod2

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.gnr.proyectod2.splashScreen.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(screen = SplashScreen()) { navigator: Navigator ->
            SlideTransition(navigator)
        }
    }
}