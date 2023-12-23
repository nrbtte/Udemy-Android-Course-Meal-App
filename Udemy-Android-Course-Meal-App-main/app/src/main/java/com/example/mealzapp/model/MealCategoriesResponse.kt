package com.example.mealzapp.model

import com.google.gson.annotations.SerializedName

//GSON deserialization
// JSON -> data classes


data class MealCategoriesResponse(
    val categories : List<Category>
)

data class Category (
    @SerializedName("idCategory")  val id: Int,
    @SerializedName("strCategory")  val name: String,
    @SerializedName("strCategoryThumb")  val description: String,
    @SerializedName("strCategoryDescription")  val imageUrl: String
)