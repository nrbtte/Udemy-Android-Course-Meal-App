package com.example.mealzapp.ui.meals

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.mealzapp.model.Category


@Composable
fun MealsCategoriesScreen() {
    val viewModel : MealsCategoriesVM = viewModel()
    val mealCategories = viewModel.mealCategories

    Scaffold(
       modifier = Modifier.fillMaxSize(),
        topBar = { AppBar("The MEALZ App") }
    )
    { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 150.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            items(mealCategories.value) { category ->
                MealCategoryCard(category){}

            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}




@Composable
fun MealCategoryCard(mealCategory: Category, onClickOpenDetails: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .clickable(onClick = { onClickOpenDetails.invoke() }),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp))
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MealCategoryPicture(mealCategory, 80.dp)
            Text(
                text = mealCategory.name,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun MealCategoryPicture(mealCategory: Category, pictureSize: Dp) {
    Card(
        modifier = Modifier.padding(16.dp),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        AsyncImage(
            model = mealCategory.imageUrl,
            contentDescription = "Meal ${mealCategory.name} example picture",
            modifier = Modifier.size(pictureSize),
            contentScale = ContentScale.Crop
        )
    }
}

