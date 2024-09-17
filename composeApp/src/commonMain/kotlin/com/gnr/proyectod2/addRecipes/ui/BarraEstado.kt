package com.gnr.proyectod2.addRecipes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

@Composable
fun BarraEstado() {

    val navigator = LocalNavigator.currentOrThrow

    Row(
        modifier = Modifier.fillMaxWidth().height(55.dp).background(color = Color.Magenta),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        IconButton(onClick = {
            /*Regresar a la pantalla anterior*/
            navigator.pop()
        }) {
            Icon(Icons.Default.Refresh, contentDescription = "")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            "AGREGAR RECETAS",
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}