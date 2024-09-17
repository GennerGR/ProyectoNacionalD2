package com.gnr.proyectod2.addRecipes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.ui.tooling.preview.Preview

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

    @Composable
    fun BarraEstado() {
        val navigator = LocalNavigator.currentOrThrow

        Row(
            modifier = Modifier.fillMaxWidth().height(55.dp).background(color = Color.Magenta),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(5.dp))
            IconButton(onClick = {
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

    @Composable
    fun InfoContent() {

        var name: String by remember { mutableStateOf("") }
        var ingredients: String by remember { mutableStateOf(" ") }
        var instructions: String by remember { mutableStateOf(" ") }

        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = ingredients,
                onValueChange = { ingredients = it },
                label = { Text("Ingredientes (Separados por comas)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = instructions,
                onValueChange = { instructions = it },
                label = { Text("Instrucciones") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text("Categoría", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(20.dp))

            /* Alternar favorito */
            Row(modifier = Modifier.fillMaxWidth()) {
                Text("Marcar como favorito", fontSize = 15.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(10.dp))
                favoriteToggle()
            }
            Spacer(modifier = Modifier.height(20.dp))
            /*Botones para agregar imagen*/
            addImage()
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {

            }) {
                Text("GUARDAR", fontSize = 16.sp, color = Color.White)
            }
        }
    }

    @Composable
    fun favoriteToggle() {
        var isFavorite by remember { mutableStateOf(false) }

        Icon(
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
            contentDescription = null,
            tint = if (isFavorite) Color.Red else Color.Gray,
            modifier = Modifier.size(22.dp).clickable {
                /*Cambia el estado de favorito*/
                isFavorite = !isFavorite
            }
        )
    }

    @Composable
    fun addImage() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(onClick = {

                }) {
                    Text("CAMARA")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = {

                }) {
                    Text("GALERIA")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("No se ha tomado ninguna foto", fontSize = 15.sp, color = Color.Black)
        }
    }

    @Preview
    @Composable
    fun previewFavoriteToggle() {
        favoriteToggle()
    }
}

