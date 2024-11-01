package com.example.moviedb.details.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.moviedb.R
import com.example.moviedb.domain.MovieDetails
import com.google.gson.Gson

@Composable
fun Shots(
    movie: MovieDetails,
    modifier: Modifier = Modifier
) {

    val json = Gson().toJson(movie)
    println("Movie JSON:---${json}")
    Column {
        Text(
            "Shots",
            fontWeight = FontWeight.W500,
            fontSize = 16.sp,
            modifier = Modifier.padding(
                start = 20.dp,
                bottom = 10.dp,
                end = 20.dp,
                top = 20.dp
            ),
            color = Color.White
        )


        val movieShot = movie.movie.backdrop_path
        AsyncImage(
            model = movieShot,
            contentDescription = "",
            placeholder = painterResource(id = R.drawable.dummy),
            error = painterResource(id = R.drawable.dummy),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth().padding(20.dp)
        )


    }

}
