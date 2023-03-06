package com.example.pantry.meal.usecase

import com.example.pantry.meal.model.MealResponse
import com.example.pantry.meal.repository.IMealRepository
import javax.inject.Inject

// Basic interface with a function to return when () is invoked on an object like useCase (CategoryViewModel)
interface IGetMealUseCase{

    // Returns a list_of_categories, a category response object
    suspend operator fun invoke(): MealResponse

}

// Redefines interface with new invoke and actually implements invoke with .getAllCategories()
class GetMealUseCase @Inject constructor(
    // New object of certain interface
    val repo: IMealRepository
): IGetMealUseCase {

    override suspend fun invoke(): MealResponse {
        return repo.getAllMeals()
    }
}