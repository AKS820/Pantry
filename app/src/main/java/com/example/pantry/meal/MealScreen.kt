package com.example.pantry.meal

import android.R
import android.content.Intent
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.pantry.MainActivity
import com.example.pantry.RecipeActivity
import com.example.pantry.category.viewmodel.MealViewModel
import com.example.pantry.meal.model.Meal


// Composable for displaying Category Screen
@Composable
fun MealScreen(
    // Initializes viewmodel, a variable with hiltViewModel which links the interface (this)
    // and data (View and Model)
    viewmodel: MealViewModel = hiltViewModel()
){
    // Return listOfCategories variable
    val listOfMeals by remember { viewmodel.listOfMeals }

    // Display in app all categories
    Column {
        Text("Meal")
        Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
        LazyColumn{
            items(listOfMeals){ item ->
                SingleMealItem(item)
            }
        }
    }

}

// Composable that takes Category and outputs image and name
@Composable
fun SingleMealItem(
    meal: Meal
){
    Row() {
        // ---
        Image(
            modifier = androidx.compose.ui.Modifier.size(40.dp), painter = rememberImagePainter(
            meal.strMealThumb
        ), contentDescription = null)
        Text(text = meal.strMeal)
        val forgotpasswordtextview = findViewById<TextView>(R.id.forgetpasswordmain)

        forgotpasswordtextview.setOnClickListener {

            val myIntent = Intent(MainActivity, forgot_password_activity::class.java)
            startActivity(myIntent)

            forgetpasswordmain.movementMethod = LinkMovementMethod.getInstance();

        }

    }
}
