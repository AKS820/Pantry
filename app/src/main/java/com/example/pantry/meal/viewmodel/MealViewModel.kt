package com.example.pantry.category.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pantry.meal.model.Meal
import com.example.pantry.meal.usecase.IGetMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// Creating the ViewModel
@HiltViewModel
class MealViewModel @Inject constructor(
    // Creating the useCase, which holds the categories with an interface
    // USE CASE
    val useCase: IGetMealUseCase
) : ViewModel(){

    // Defining private/public members, the list of categories
    private val _listOfMeal: MutableState<List<Meal>> = mutableStateOf(emptyList())
    val listOfMeals: State<List<Meal>> = _listOfMeal

    // Starting up the viewModel when constructed, calling the useCase to get categories, filling private member
    // with useful data
    init{
        viewModelScope.launch {
            val mealsList = useCase()
            _listOfMeal.value = mealsList.meals
        }
    }

}