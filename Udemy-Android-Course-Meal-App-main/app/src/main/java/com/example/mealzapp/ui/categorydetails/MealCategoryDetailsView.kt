package com.example.mealzapp.ui.categorydetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mealzapp.model.Category
import com.example.mealzapp.ui.categories.MealCategoryPicture
import com.example.mealzapp.ui.categories.MealsCategoriesVM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailsView(category: Category?, navController: NavHostController) {
    val viewModel : CategoryDetailsVM = viewModel()
    val meals = viewModel.mealsByCategory
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
            title = {
                Text(text = category?.name?:"Default value")
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigate("meal_categories") }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow back"
                    )
                }
            }
        )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
        {
                LazyColumn {
                    item {
                        Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                        )
                        {
                            MealCategoryPicture(category, 240.dp)
                            Text(
                                text = category?.name?:"Default value",
                                style = MaterialTheme.typography.titleLarge)
                            Spacer(modifier = Modifier.height(50.dp))
                            Text(text = category?.description?:"Default value")
                            Spacer(modifier = Modifier.height(50.dp))
                        } }

                    items(meals.value) { meal ->
                        Text(meal.name)

                    }
                }

        }


    }
}

