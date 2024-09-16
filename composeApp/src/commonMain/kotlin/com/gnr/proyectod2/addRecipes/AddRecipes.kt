package com.gnr.proyectod2.addRecipes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class AddRecipes : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth().height(55.dp).background(color = Color.Magenta), horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = {
                    navigator.pop()
                }) {
                    Text("Atras")
                }
                Spacer(modifier = Modifier.weight(1f))
                Text("AGREGAR RECETAS", fontSize = 22.sp, color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}