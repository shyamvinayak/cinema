package com.example.moviedb.details.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.moviedb.R
import com.example.moviedb.domain.MovieDetails
import com.example.moviedb.home.component.SlidBanner
import okhttp3.internal.toImmutableList

@Composable
fun MovieTextContent(
    movie: MovieDetails,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
    ) {
        val (header, overview) = createRefs()

        MovieDetailsHeader(
            movie = movie,
            modifier = Modifier
                .constrainAs(header) {
                    start.linkTo(parent.start, 5.dp)
                    top.linkTo(parent.top, 16.dp)
                }
            )

        Text(
            text = movie.movie.overview,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .constrainAs(overview) {
                    linkTo(
                        start = parent.start,
                        startMargin = 24.dp,
                        end = parent.end,
                        endMargin = 24.dp
                    )
                    top.linkTo(header.bottom, 8.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent

                }
        )

        Column (
            modifier = Modifier
                .constrainAs(createRef()) {
                    linkTo(
                        start = parent.start,
                        end = parent.end
                    )
                    top.linkTo(overview.bottom, 12.dp)
                    bottom.linkTo(parent.bottom,24.dp)
                    width = Dimension.fillToConstraints
                }
        ){
            Cast(list = movie.movie.casts.toImmutableList())
            Shots(movie)
        }




    }

}