package com.alejandromoreno.instagramclone.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.alejandromoreno.instagramclone.model.Post
@Composable
fun FeedWithIndex(posts: List<Post>) {

    LazyColumn {

        // usa itemsIndexed en lugar de items
        itemsIndexed(posts) { index, post ->

            Text("Post #$index: ${post.username}")

        }

    }
}