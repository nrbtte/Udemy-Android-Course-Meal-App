package com.example.mealzapp.ui.categorydetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.Category
import com.example.mealzapp.model.Meal
import com.example.mealzapp.model.MealCategoryRepository
import com.example.mealzapp.model.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryDetailsVM(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val repository: MealCategoryRepository = MealCategoryRepository.getInstance()
    private val mealRepository: MealsRepository = MealsRepository()
    var mealCategoryState = mutableStateOf<Category?>(null)


    val mealsByCategory: MutableState<List<Meal>> = mutableStateOf(emptyList<Meal>())
    init {
        val categoryId = savedStateHandle.get<Int>("categoryId")?: -1
        mealCategoryState.value = repository.getCategory(categoryId)
        val userInfo: String = mealCategoryState.value!!.name
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMealsByCategory(userInfo)
            mealsByCategory.value = meals
        }
    }



    private suspend fun getMealsByCategory(categoryName: String) : List<Meal> {
        return mealRepository.getMealsByCategory(categoryName).meals
    }
}