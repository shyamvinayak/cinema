package com.example.moviedb.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.moviedb.R

@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)/*
            .background(Color.White)*/,
        verticalAlignment = Alignment.CenterVertically // Align vertically to center
    ) {
        Image(
            painter = rememberAsyncImagePainter(R.mipmap.ic_launcher_round),
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentDescription = "logo",
            contentScale = ContentScale.Crop
        )

        // Space between profile and name
        Spacer(modifier = Modifier.width(16.dp))

        // Name text
        Text(
            text = "Cinema", // Replace with your dynamic name
            fontSize = 25.sp,
            fontWeight = FontWeight.W600,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeader() {
    HomeHeader()
}