package com.example.pantry.recipes.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pantry.meal.model.Meal
import com.example.pantry.recipes.model.Recipe
import com.example.pantry.recipes.model.RecipeAccesser
import com.example.pantry.recipes.usecase.IGetRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// Creating the ViewModel
@HiltViewModel
class RecipeViewModel @Inject constructor(
    // Creating the useCase, which holds the recipe with an interface
    // USE CASE
    val useCase: IGetRecipeUseCase
) : ViewModel(){

    // Defining private/public members, the list of categories
    private val _recipes: MutableState<List<Recipe>> =  mutableStateOf(emptyList())
    val recipes: State<List<Recipe>> = _recipes

    // Starting up the viewModel when constructed, calling the useCase to get categories, filling private member
    // with useful data
    init{
        viewModelScope.launch {
            val mealsList = useCase()
            _recipes.value = mealsList.recipe
        }
    }

}