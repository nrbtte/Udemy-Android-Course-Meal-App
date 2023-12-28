package com.example.mealzapp.model

import com.example.mealzapp.model.api.MealsAPI


class MealCategoryRepository(private val webService: MealsAPI = MealsAPI()) {
    private var cachedMealCategories = listOf<Category>()
    suspend fun getCategories(): MealCategoriesResponse {
        val response = webService.getCategories()
        cachedMealCategories = response.categories
        return response
    }

    fun getCategory(id: Int): Category? {
        return cachedMealCategories.firstOrNull() {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance : MealCategoryRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealCategoryRepository().also { instance = it  }
        }
    }
}