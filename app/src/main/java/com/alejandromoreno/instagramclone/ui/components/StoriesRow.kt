package com.alejandromoreno.instagramclone.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.Arrangement
import com.alejandromoreno.instagramclone.model.Story

@Composable
fun StoriesRow(stories: List<Story>) {

    // usa LazyRow (no LazyColumn) para scroll horizontal
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),

        // parámetro que controla el espacio horizontal entre stories
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(
            items = stories,
            key = { story -> story.id }
        ) { story ->

            StoryItem(story = story)

        }
    }
}

@Composable
fun StoryItem(story: Story) {

    // si hasSeen es false -> gradiente, si es true -> gris
    val borderBrush = if (!story.hasSeen) {
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFf09433),
                Color(0xFFdc2743),
                Color(0xFFbc1888)
            )
        )
    } else {
        SolidColor(Color.LightGray)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(70.dp)
    ) {

        Box(
            modifier = Modifier
                .size(64.dp)
                .border(
                    width = 2.dp,
                    brush = borderBrush,

                    // forma circular del borde
                    shape = CircleShape
                )
                .padding(3.dp),
            contentAlignment = Alignment.Center
        ) {

            AsyncImage(
                model = story.profileImageUrl,
                contentDescription = story.username,
                modifier = Modifier
                    .size(56.dp)

                    // imagen redonda
                    .clip(CircleShape),

                contentScale = ContentScale.Crop
            )
        }

        Spacer(Modifier.height(4.dp))

        Text(
            text = story.username,
            fontSize = 11.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}