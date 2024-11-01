package com.example.moviedb.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.moviedb.MovieViewModel
import com.example.moviedb.home.model.movieThumbnails
import kotlinx.coroutines.delay
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.moviedb.R
import com.example.moviedb.domain.Movie
import kotlin.random.Random

@Composable
fun HomeBody(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MovieViewModel = hiltViewModel(),
) {
    val movies = viewModel.moviePagingFlow.collectAsLazyPagingItems()
    val state = rememberPagerState(pageCount = { movies.itemCount })
    var selectedData by remember { mutableStateOf(0) }
    val randomMovies: MutableState<List<Movie>> = remember { mutableStateOf(emptyList()) }

    LaunchedEffect(state) {
        while (true) {
            delay(3000) // 3-second delay

            try {
                if(movies.itemCount>=6){
                    val randomIndexes = List(6) { Random.nextInt(0, movies.itemCount) }
                    randomMovies.value = randomIndexes.mapNotNull { index -> movies.peek(index) }
                    val nextPage = (state.currentPage + 1) % movies.itemCount
                    state.animateScrollToPage(nextPage)
                }
            }catch (e:Exception){
               println("EXCEPTION OCCUR:-$e")
            }

        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        // Horizontal Pager Section with fixed height
        SlidBanner(state, movies)

        // Vertical Grid Section
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight() // Fills remaining space
        ) {
            items(movies.itemCount) { index ->
                movies[index]?.let {movie->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(300.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .clickable {
                                //selectedData = index
                                navController.navigate("single_movie/${movie.movie_id}")
                            }
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(movie.poster_path)
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.placeholder),
                            contentDescription = "movie poster",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize() // Fill the box to prevent layout issues
                        )
                    }
                }

            }
        }
    }


}