package com.example.pantry.recipes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pantry.meal.SingleMealItem
import com.example.pantry.recipes.viewmodel.RecipeViewModel
import com.example.pantry.recipes.model.Recipe


// Composable for displaying Recipe Screen
@Composable
fun IngredientsScreen(
    viewmodel: RecipeViewModel = hiltViewModel()
) {

    val recipe by remember { viewmodel.recipes }

    Text("Recipe")
    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))

    LazyColumn{
        items(recipe){ item ->
            Text(item.strMeal)
            Text(item.strInstructions)
        }
    }
}