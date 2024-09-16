package com.gnr.proyectod2.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.gnr.proyectod2.addRecipes.AddRecipes
import com.gnr.proyectod2.main.uiTabs.RecetasTab
import com.gnr.proyectod2.main.uiTabs.SecondTab

class MainScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        TabNavigator(RecetasTab) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Recetario de kev") },
                        actions = {
                            IconButton(onClick = { /* Acción de búsqueda */ }) {
                                Icon(Icons.Default.Search, contentDescription = "Buscar")
                            }
                            IconButton(onClick = { /* Acción de refresh o sincronización */ }) {
                                Icon(Icons.Default.Refresh, contentDescription = "Sincronizar")
                            }
                        }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            navigator.push(AddRecipes())
                        },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Agregar")
                    }
                },
                content = {
                    Column(modifier = Modifier.fillMaxSize()) {
                        val currentTab = LocalTabNavigator.current.current

                        // Mostrar el filtro solo en la pestaña de recetas
                        if (currentTab == RecetasTab) {
                            FiltroRecetasDropdown()
                        }

                        // Contenido de la pestaña seleccionada
                        CurrentTab()
                    }
                },
                bottomBar = {
                    BottomNavigationBar()
                }
            )
        }
    }

    // Función para el menú desplegable de filtrado de recetas
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
                listOf(
                    "Todo",
                    "Desayuno",
                    "Almuerzo",
                    "Cena",
                    "Postre",
                    "Snack"
                ).forEach { option ->
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

    // Pestañas de recetas y favoritos
    @Composable
    fun BottomNavigationBar() {
        val tabNavigator = LocalTabNavigator.current

        BottomNavigation {
            BottomNavigationItem(
                selected = tabNavigator.current == RecetasTab,
                onClick = {
                    tabNavigator.current = RecetasTab
                },
                icon = {
                    Icon(
                        RecetasTab.options.icon!!,
                        contentDescription = "Recetas"
                    )
                },
                label = {
                    Text(RecetasTab.options.title)
                }
            )
            BottomNavigationItem(
                selected = tabNavigator.current == SecondTab,
                onClick = {
                    tabNavigator.current = SecondTab
                },
                icon = {
                    Icon(
                        SecondTab.options.icon!!,
                        contentDescription = "Favoritos"
                    )
                },
                label = {
                    Text(SecondTab.options.title)
                }
            )
        }
    }
}
