package com.gnr.proyectod2.addRecipes.ui

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
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun InfoContent() {

    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*Inputs*/
        outlinedTexFields()

        /*Seleccionar categoría de la receta*/
        categoríaReceta()
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

        /*Boton para guardar y subir la receta a "firebase"*/
        Button(onClick = {

        }) {
            Text("GUARDAR", fontSize = 16.sp, color = Color.White)
        }
    }
}

@Composable
fun outlinedTexFields() {

    var name: String by remember { mutableStateOf("") }
    var ingredients: String by remember { mutableStateOf(" ") }
    var instructions: String by remember { mutableStateOf(" ") }
    var preparationTime: String by remember {mutableStateOf("")}

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
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
        value = preparationTime,
        onValueChange = { instructions = it },
        label = { Text ("Tiempo de preparación")},
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(20.dp))
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun categoríaReceta() {

    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("")}

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded}
    ) {
        TextField(
            value = selectedOption,
            onValueChange = {},
            label = { Text("Seleccionar categoría:") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded)},
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false}
        ) {
            listOf(
                "Desayuno",
                "Almuerzo",
                "Cena",
                "Postre",
                "Snack",
                "Otro"
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