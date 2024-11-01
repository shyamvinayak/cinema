package com.example.moviedb.navigation

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviedb.home.ui.HomeScreen
import com.example.moviedb.SplashScreen
import com.example.moviedb.details.ui.MovieDetails
import com.example.moviedb.getActivity

@Composable
fun NavigationGraph(context: Context) {
    val navController = rememberNavController()
    val activity = getActivity()
    var showExitDialog by remember { mutableStateOf(false) }
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Screens.HomeScreen.route) {
            BackHandler {
                showExitDialog = true
            }
            HomeScreen(
                navController,
                showExitDialog = showExitDialog,
                onDismissDialog = { showExitDialog = false },
                onConfirmExit = { activity?.finish() }
            )
        }
        composable(Screens.DetailScreen.route) {
            BackHandler {
                navController.popBackStack()
            }
            val movieId = it.arguments?.getString("movieId")
            MovieDetails(context,"$movieId",navController)
        }

    }

}

