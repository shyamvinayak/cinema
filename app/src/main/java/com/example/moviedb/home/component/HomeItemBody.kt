package com.example.moviedb.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text
import com.example.moviedb.home.model.MovieItem

@Composable
fun HomeItemBody(item: MovieItem) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.7f),
                        Color.Transparent
                    )
                )
            ), contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .width(500.dp)
                .wrapContentHeight()
                .padding(32.dp)
        ) {
            Text(
                text = item.title, fontSize = 32.sp, color = Color.White
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = item.description,
                fontSize = 16.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Text(
                    text = "Watch on:", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Netflix", fontSize = 14.sp, color = Color.White
                )
            }
        }
    }
}

