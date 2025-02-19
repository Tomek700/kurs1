package com.example.kurs1.navigation

import com.example.kurs1.screens.detals.DetailsScreen
import com.example.kurs1.screens.home.HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Preview
@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    )
    {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(
            MovieScreens.DetailsScreen.name + "/{move}",
            arguments = listOf(navArgument(name = "move") { type = NavType.IntType })
        ) { backStackEntry ->

            DetailsScreen(navController = navController, movieId = backStackEntry.arguments?.getInt("move"))

        }
    }
}