package com.gnr.proyectod2.addRecipes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.gnr.proyectod2.addRecipes.ui.BarraEstado
import com.gnr.proyectod2.addRecipes.ui.InfoContent

class AddRecipes : Screen {

    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BarraEstado()
            InfoContent()
        }
    }

//    @Composable
//    fun BarraEstado() {
//
//    }

//    @Composable
//    fun InfoContent() {
//    }

}

