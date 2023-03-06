package com.example.pantry.meal.repository

import com.example.pantry.meal.service.IMealService
import com.example.pantry.meal.model.Meal
import com.example.pantry.meal.model.MealResponse
import javax.inject.Inject

// Has the getAllCategories() function
interface IMealRepository{
    suspend fun getAllMeals(): MealResponse
}

// A class to override it and do more work
class MealRepository @Inject constructor(
    // Another interface to provide retrofit service
    val service: IMealService
): IMealRepository {
    // Override function for interface
    override suspend fun getAllMeals(): MealResponse {
        return service.getAllMeals()
    }
}