package com.gnr.proyectod2.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.gnr.proyectod2.main.uiTabs.RecetasTab
import com.gnr.proyectod2.main.uiTabs.SecondTab

class MainScreen : Screen {
    @Composable
    override fun Content() {
        TabNavigator(
            RecetasTab,
            tabDisposable = {
                TabDisposable(
                    it,
                    listOf(RecetasTab)
                )
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(it.current.options.title) },
                        actions = {
                            //Para después agregar acciones
                        }
                    )
                },
                content = {
                    Column(modifier = Modifier.fillMaxSize()) {
                        // Filtro dropdown
                        FiltroRecetasDropdown()

                        //Contenido de la pestaña seleccionada (Recetas, etc.)
                        CurrentTab()
                    }
                }
            )
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun FiltroRecetasDropdown() {
        var expanded by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("Todo") }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedOption,
                onValueChange = {},
                label = { Text("Filtrar por:") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listOf("Todo", "Desayuno", "Almuerzo", "Cena", "Postre", "Snack").forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOption = option
                            expanded = false
                        }
                    ) {
                        Text(text = option)
                    }
                }
            }
        }
    }

}