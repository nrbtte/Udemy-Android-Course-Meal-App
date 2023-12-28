package com.example.mealzapp.model

import com.example.mealzapp.model.api.MealsAPI

class MealsRepository(private val webService: MealsAPI = MealsAPI()) {
    suspend fun getMealsByCategory(categoryName: String): MealsResponse {
        return webService.getMealsByCategory(categoryName)
    }

}