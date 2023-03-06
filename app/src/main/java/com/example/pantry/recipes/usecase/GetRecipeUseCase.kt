package com.example.pantry.recipes.usecase

import com.example.pantry.recipes.model.RecipeAccesser
import com.example.pantry.recipes.service.IRecipeService
import javax.inject.Inject

// Basic interface with a function to return when () is invoked on an object like useCase (CategoryViewModel)
interface IGetRecipeUseCase{

    // Returns a list_of_categories, a category response object
    suspend operator fun invoke(): RecipeAccesser

}

// Redefines interface with new invoke and actually implements invoke with .getAllCategories()
class GetRecipeUseCase @Inject constructor(
    // New object of certain interface
    val service: IRecipeService
): IGetRecipeUseCase {

    override suspend fun invoke(): RecipeAccesser {
        return service.getRecipe()
    }
}