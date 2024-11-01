package com.example.moviedb.home.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun ExitWarningDialog(onDismiss: () -> Unit, onConfirmExit: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss, // Dismiss the dialog when touched outside
        title = { Text("Exit App?") },
        text = { Text("Are you sure you want to exit the app?") },
        confirmButton = {
            Button(onClick = onConfirmExit) {
                Text("Exit")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}