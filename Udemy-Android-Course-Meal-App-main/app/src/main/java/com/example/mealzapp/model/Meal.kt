package com.example.mealzapp.model

import com.google.gson.annotations.SerializedName
data class Meal(
    @SerializedName("idMeal") val id: Int,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
)

data class MealsResponse(
    val meals : List<Meal>
)

