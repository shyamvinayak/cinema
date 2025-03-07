package com.example.moviedb.domain

data class Cast(
    val character: String,
    val created_at: Any,
    val id: String,
    val movie_id: Int,
    val name: String,
    val original_name: String,
    val popularity: String,
    val profile_path: String,
    val updated_at: Any
)