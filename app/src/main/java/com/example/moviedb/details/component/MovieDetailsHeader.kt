package com.example.moviedb.details.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.moviedb.domain.MovieDetails

@Composable
fun MovieDetailsHeader(
    movie: MovieDetails,
    modifier: Modifier = Modifier
) {

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
    ) {
        val (imdb,ranking, title) = createRefs()

        IMDBRanking(
            modifier = Modifier
                .constrainAs(imdb) {
                    start.linkTo(parent.start, 24.dp)
                    top.linkTo(parent.top, 16.dp)
                }
        )
        VoteMovie(
            voteAverage = movie.movie.vote_average,
            voteCount = movie.movie.vote_count.toInt(),
            modifier = Modifier
                .constrainAs(ranking) {
                    start.linkTo(imdb.end, 8.dp)
                    end.linkTo(parent.end, 24.dp)
                    top.linkTo(imdb.top)
                    bottom.linkTo(imdb.bottom)
                    width = Dimension.fillToConstraints
                }
        )
        MovieTitle(
            movie = movie,
            modifier = Modifier
                .constrainAs(title) {
                    linkTo(
                        start = parent.start,
                        startMargin = 24.dp,
                        end = parent.end,
                        endMargin = 24.dp
                    )
                    top.linkTo(imdb.bottom, 8.dp)
                    width = Dimension.fillToConstraints
                }
        )

    }

}