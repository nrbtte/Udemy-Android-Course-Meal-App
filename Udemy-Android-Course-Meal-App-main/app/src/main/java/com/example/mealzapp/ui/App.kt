package com.example.mealzapp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzapp.ui.categories.MealsCategoriesView
import com.example.mealzapp.ui.categorydetails.CategoryDetailsVM
import com.example.mealzapp.ui.categorydetails.CategoryDetailsView

@Composable
fun AndroidApplication() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "meal_categories"){
        composable("meal_categories") {
            MealsCategoriesView { navId ->
                navController.navigate("meal_category_details/${navId}")
            }
        }

        composable (
            route = "meal_category_details/{categoryId}",
            arguments = listOf(navArgument("categoryId") {
                type = NavType.IntType
            })) { navBackStackEntry ->
                val detailsViewModel: CategoryDetailsVM = viewModel();
                CategoryDetailsView(detailsViewModel.mealCategoryState.value, navController)
            }
    }
}


