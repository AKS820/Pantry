package com.example.pantry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.pantry.meal.MealScreen
import com.example.pantry.ui.theme.PantryTheme

class RecipeActivity : ComponentActivity() {
    // Starting up app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set root view
        setContent {
            // Set Color Theme And Initial Composable Content
            PantryTheme(true) {
                // Calls composable below
                MealApp()
            }
        }
    }
}

@Composable
fun MealApp(){
    MealScreen()
}