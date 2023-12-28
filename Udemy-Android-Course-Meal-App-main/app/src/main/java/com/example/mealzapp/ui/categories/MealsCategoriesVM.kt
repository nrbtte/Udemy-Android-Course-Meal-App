package com.example.mealzapp.ui.categories

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.Category
import com.example.mealzapp.model.MealCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesVM (private val repository: MealCategoryRepository = MealCategoryRepository.getInstance()): ViewModel() {
    val mealCategories: MutableState<List<Category>> = mutableStateOf(emptyList<Category>())



    init {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = getMealCategories()
            mealCategories.value = categories;
        }
    }

    private suspend fun getMealCategories() : List<Category> {
        return repository.getCategories().categories
    }


}