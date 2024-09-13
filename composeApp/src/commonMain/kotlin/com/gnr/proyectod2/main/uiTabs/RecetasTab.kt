package com.gnr.proyectod2.main.uiTabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object RecetasTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Recetas",
                    icon = null
                )
            }
        }

    @Composable
    override fun Content() {
        Box(
            Modifier.fillMaxSize().background(color = Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text("Recetas", color = Color.Gray, fontSize = 15.sp)
        }
    }

}