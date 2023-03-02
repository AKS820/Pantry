package com.example.pantry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pantry.category.CategoryScreen
import com.example.pantry.meal.MealScreen
import com.example.pantry.meal.model.Meal
import com.example.pantry.ui.theme.PantryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // Starting up app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set root view
        setContent {
            // Set Color Theme And Initial Composable Content
            PantryTheme(true) {
                // Calls composable below
                PantryApp()
            }
        }
    }
}

// Calls initial screen
@Composable
fun PantryApp(){
    MealScreen()
}
// https://www.themealdb.com/api/json/v1/1/categories.php