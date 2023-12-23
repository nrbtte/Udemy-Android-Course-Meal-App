package com.example.mealzapp.model

import com.example.mealzapp.model.api.MealsAPI
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MealsRepository(private val webService: MealsAPI = MealsAPI()) {
    suspend fun getCategories(): MealCategoriesResponse {
        return webService.getCategories()
    }
}