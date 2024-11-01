package com.example.moviedb.home.model

import com.example.moviedb.R

data class MovieItem (
    val imageResId: Int,
    val title: String,
    val description: String
)

val movieItems = listOf(
    MovieItem(R.drawable.movie_one, "Title 1", "Description for item 1"),
    MovieItem(R.drawable.movie_two, "Title 2", "Description for item 2"),
    MovieItem(R.drawable.movie_three, "Title 3", "Description for item 3"),
    MovieItem(R.drawable.movie_four, "Title 4", "Description for item 4"),
    MovieItem(R.drawable.movie_five, "Title 5", "Description for item 5"),
    MovieItem(R.drawable.movie_six, "Title 6", "Description for item 6")
)

val movieThumbnails = listOf(
    MovieItem(R.drawable.banner_one, "Thumb 1", "Description for item 1"),
    MovieItem(R.drawable.banner_two, "Thumb 2", "Description for item 2"),
    MovieItem(R.drawable.banner_three, "Thumb 3", "Description for item 3"),
    MovieItem(R.drawable.banner_four, "Thumb 4", "Description for item 4"),
    MovieItem(R.drawable.banner_five, "Thumb 5", "Description for item 5"),
    MovieItem(R.drawable.banner_six, "Thumb 6", "Description for item 6"),
    MovieItem(R.drawable.banner_seven, "Thumb 7", "Description for item 7"),
    MovieItem(R.drawable.banner_eight, "Thumb 8", "Description for item 8")
)