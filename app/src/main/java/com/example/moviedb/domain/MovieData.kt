package com.example.moviedb.domain

import com.example.moviedb.remote.MovieDto
import com.google.rpc.Help


data class MovieData(
    val current_page: Int,
    val `data`: List<MovieDto>,
    val first_page_url: String,
    val from: Int,
    val last_page: Int,
    val last_page_url: String,
    val links: List<Help.Link>,
    val next_page_url: String,
    val path: String,
    val per_page: Int,
    val prev_page_url: Any,
    val to: Int,
    val total: Int
)