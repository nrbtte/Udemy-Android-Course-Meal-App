package com.example.mealzapp.model.api

import com.example.mealzapp.model.MealCategoriesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

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

    interface API {
        @GET("categories.php")
        suspend fun getCategories() : MealCategoriesResponse
    }

}