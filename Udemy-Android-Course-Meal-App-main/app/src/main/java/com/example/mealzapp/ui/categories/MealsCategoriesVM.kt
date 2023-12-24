package com.example.mealzapp.ui.categories

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.Category
import com.example.mealzapp.model.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesVM (private val repository: MealsRepository = MealsRepository.getInstance()): ViewModel() {
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

    fun filterSelectedCategory(id: Int) : Category {
        return mealCategories.value.first { category -> category.id == id }
    }

//    fun setSelectedCategory(id: Int) {
//        selectedItem = filterSelectedCategory(id)
//        Log.d("BBBBBBBBBBBBBB", "${selectedItem.id} ${selectedItem.name} ${selectedItem.description}")
//
//    }

}