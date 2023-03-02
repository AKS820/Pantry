package com.example.pantry.category.service

import com.example.pantry.meal.model.MealResponse
import retrofit2.http.GET

// Make request
interface IMealService {
    @GET("filter.php?i=chicken_breast")
    suspend fun getAllMeals() : MealResponse
}

//https://www.themealdb.com/api/json/v1/1/categories.php