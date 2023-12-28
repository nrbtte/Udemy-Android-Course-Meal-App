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
    @SerializedName("strCategoryDescription")  val description: String,
    @SerializedName("strCategoryThumb")  val imageUrl: String

)