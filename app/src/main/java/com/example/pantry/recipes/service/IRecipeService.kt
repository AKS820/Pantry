package com.example.pantry.recipes.service

import com.example.pantry.recipes.model.RecipeAccesser

import retrofit2.http.GET

// Make request
interface IRecipeService {
    @GET("lookup.php?i=52772")
    suspend fun getRecipe() : RecipeAccesser
}