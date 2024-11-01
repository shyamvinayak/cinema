package com.example.moviedb.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.moviedb.home.component.HomeHeader

import androidx.navigation.NavHostController
import com.example.moviedb.MovieViewModel
import com.example.moviedb.home.component.ExitWarningDialog
import com.example.moviedb.home.component.HomeBody


@Composable
fun HomeScreen(
    navController: NavController,
    showExitDialog: Boolean,
    onDismissDialog: () -> Unit,
    onConfirmExit: () -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {

        // Header
        Box(modifier = Modifier.fillMaxWidth()) {
            HomeHeader()
        }

        // Body
        Box(modifier = Modifier.fillMaxSize()) {
            HomeBody(navController)
        }
    }

    // Show the exit dialog if the state is true
    if (showExitDialog) {
        ExitWarningDialog(onDismiss = onDismissDialog, onConfirmExit = onConfirmExit)
    }

}

/*@Preview(showBackground = true)
@Composable
fun PreviewHeader() {
    HomeScreen( false, {}, {})
}*/
