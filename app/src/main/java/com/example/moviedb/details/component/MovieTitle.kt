package com.example.moviedb.details.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.moviedb.domain.MovieDetails
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun MovieTitle(
    movie: MovieDetails,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    Text(
        text = movie.movie.original_title,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = textAlign,
        modifier = modifier
    )
}

fun extractYear(dateString: String): Int {
    val formatter = SimpleDateFormat("E, MM/dd/yyyy", Locale.US)
    val date = formatter.parse(dateString)
    val calendar = Calendar.getInstance()
    if (date != null) {
        calendar.time = date
    }
    return calendar.get(Calendar.YEAR)
}