package com.example.pantry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.pantry.meal.MealScreen
import com.example.pantry.ui.theme.PantryTheme
import dagger.hilt.android.AndroidEntryPoint
import android.widget.Button
import androidx.compose.material.Text
import com.example.pantry.recipes.IngredientsScreen

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

        /*val button = findViewById<Button>(R.id.button)
        button?.setOnClickListener {
            setContent {
                IngredientInvoke()
            }
        }*/
    }
}

// Calls initial screen
@Composable
fun PantryApp(){
    //MealScreen()
    IngredientsScreen()
}

@Composable
fun IngredientInvoke(){
    Text("I like chicken")
}
// https://www.themealdb.com/api/json/v1/1/categories.php