package com.example.moviedb.navigation

sealed class Screens(val route: String) {
    data object SplashScreen: Screens("SplashScreen")
    data object HomeScreen: Screens("HomeScreen")
    data object DetailScreen: Screens("single_movie/{movieId}")
}