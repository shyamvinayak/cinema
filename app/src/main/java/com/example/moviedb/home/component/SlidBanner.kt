package com.example.moviedb.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.example.moviedb.domain.Movie
import kotlin.random.Random

@Composable
fun SlidBanner(state: PagerState, movies: LazyPagingItems<Movie>) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // HorizontalPager at the top
        HorizontalPager(
            state = state,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) { index ->

           movies[index]?.let {
               val roundedRating = it.popularity.coerceIn(0.0, 5.0)

               val rate = if (roundedRating == roundedRating.toInt().toDouble()) {
                   roundedRating.toInt().toString() // Show as an integer
               } else {
                   String.format("%.1f", roundedRating) // Show with one decimal place
               }


               Box(
                   modifier = Modifier
                       .padding(8.dp)
                       .clip(RoundedCornerShape(10.dp))
                       .fillMaxSize()
               ) {
                   // Image background
                   Image(
                       painter = rememberAsyncImagePainter(model = it.backdrop_path),
                       contentDescription = "",
                       modifier = Modifier.fillMaxSize(),
                       contentScale = ContentScale.Crop
                   )

                   Column(
                       modifier = Modifier
                           .align(Alignment.BottomStart) // Align the column at the bottom center
                           .background(Color.Black.copy(alpha = 0.5f)) // Semi-transparent background
                           .padding(8.dp) // Add padding for better readability
                   ) {
                       // Main text
                       Text(
                           text = it.original_title,
                           color = Color.White, // Text color
                           style = MaterialTheme.typography.labelMedium // Use your desired text style
                       )


                       Row(
                           verticalAlignment = Alignment.CenterVertically,
                           modifier = Modifier.padding(top = 4.dp) // Add space above the row
                       ) {
                           // Convert and display rating
                           DisplayRating(it.popularity) // Call the function to display the rating
                       }
                   }
               }
           }
        }


    }
}@Composable
fun DisplayRating(rating: Double) {
    // Ensure the rating is between 0 and 5
    val roundedRating = rating.coerceIn(0.0, 5.0)

    // Display stars
    for (i in 1..5) {
        when {
            i <= roundedRating.toInt() -> {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Full Star",
                    tint = Color.Yellow // Star color
                )
            }
            i == roundedRating.toInt() + 1 && (roundedRating % 1) >= 0.5 -> {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "Half Star",
                    tint = Color.Gray // Star color
                )
            }
            else -> {
                Icon(
                    imageVector = Icons.Outlined.Star, // Use outlined star for empty stars
                    contentDescription = "Empty Star",
                    tint = Color.Gray // Empty star color
                )
            }
        }
    }

    // Display the rounded rating count without .0 if it's a whole number
    Text(
        text = if (roundedRating == roundedRating.toInt().toDouble()) {
            roundedRating.toInt().toString() // Show as an integer
        } else {
            String.format("%.1f", roundedRating) // Show with one decimal place
        },
        color = Color.White,
        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold), // Bold style
        modifier = Modifier.padding(start = 4.dp) // Space between stars and rating text
    )
}




// Dot indicators
/*Row(
    horizontalArrangement = Arrangement.Center,
    modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth() // Make the Row take the full width
) {
    repeat(movies.itemSnapshotList.items.size) { pageIndex ->
        val color =
            if (pageIndex == state.currentPage) Color.White else Color.Gray.copy(alpha = 0.3f)
        val size = if (pageIndex == state.currentPage) 10.dp else 6.dp
        Box(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .size(size)
                .clip(CircleShape)
                .background(color)
        )
    }
}*/