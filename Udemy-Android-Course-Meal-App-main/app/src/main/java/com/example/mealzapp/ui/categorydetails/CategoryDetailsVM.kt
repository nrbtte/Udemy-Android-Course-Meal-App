package com.example.mealzapp.ui.categorydetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.Category
import com.example.mealzapp.model.MealsRepository

class CategoryDetailsVM(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val repository: MealsRepository = MealsRepository.getInstance()
    var mealState = mutableStateOf<Category?>(null)
    init {
        val categoryId = savedStateHandle.get<Int>("categoryId")?: -1
        mealState.value = repository.getCategory(categoryId)
    }
}