package com.example.mealzapp.model.api

import com.example.mealzapp.model.MealCategoriesResponse
import com.example.mealzapp.model.MealsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MealsAPI {
    private lateinit var api: API
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(API::class.java)
    }

    suspend fun getCategories() : MealCategoriesResponse {
        return api.getCategories()
    }

    suspend fun getMealsByCategory(categoryName: String) : MealsResponse {
        return api.getMealsByCategory(categoryName)
    }

    interface API {
        @GET("categories.php")
        suspend fun getCategories() : MealCategoriesResponse

        @GET("filter.php")
        suspend fun getMealsByCategory(@Query("c") categoryName: String) : MealsResponse
    }

}