package com.example.pantry.meal.service

import com.example.pantry.meal.model.MealResponse
import retrofit2.http.GET

// Make request
interface IMealService {
    @GET("filter.php?i=chicken_breast,garlic")
    suspend fun getAllMeals() : MealResponse
}
// https://www.themealdb.com/api/json/v2/9973533/filter.php?i=chicken_breast,garlic GET MEAL ID
// https://www.themealdb.com/api/json/v2/9973533/lookup.php?i=52772 GET RECIPE