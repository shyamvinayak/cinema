package com.example.moviedb.details.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import java.math.RoundingMode

@Composable
fun VoteMovie(
    voteAverage: Double,
    voteCount: Int,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier = modifier) {
        val (icon, voteAverageRef, voteCountRef) = createRefs()
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star ranking",
            tint = Color(0XFFF9C204),
            modifier = Modifier
                .size(24.dp)
                .constrainAs(icon) {
                    start.linkTo(parent.start, 4.dp)
                    linkTo(
                        top = parent.top,
                        bottom = parent.bottom
                    )
                }
        )
        Text(
            text = voteAverage.toBigDecimal().setScale(1, RoundingMode.CEILING).toString(),
            style = MaterialTheme.typography.headlineLarge,
            color = Color(0XFFF9C204),
            modifier = Modifier
                .constrainAs(voteAverageRef) {
                    start.linkTo(icon.end, 4.dp)
                    linkTo(
                        top = icon.top,
                        bottom = icon.bottom
                    )
                }
        )
    }
}