package com.example.kurs1.screens.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kurs1.MovieRow
import android.util.Log
import com.example.kurs1.navigation.MovieScreens


@Composable
fun HomeScreen(navController: NavController)
{
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor=Color.Magenta,
                elevation=5.dp
            ) {
                Text(text = "Movies ")
            }
        },
    ) {it->Column (
        modifier = Modifier
            .padding(it))
    { MainContent(navController=navController)
    }
    }
}

@Composable
fun MainContent(navController: NavController,
                moviesList:List<String> = listOf(
                    "Avatar",
                    "555",
                    "Harry Potter",
                    "Life",
                    "Lolek",
                    "Bolek",
                    "Krecik"
                )){
    Column(modifier=Modifier.padding(12.dp)){
        LazyColumn {
            items(items = moviesList){
                //Text(text=it)
                //MovieRow(movie=it){movie -> Log.d("TAG", "MainContent:$movie")}
                MovieRow(movie=it){movie->navController.navigate(route=MovieScreens.DetailsScreen.name+"/$movie")}
            }
        }
    }

}
