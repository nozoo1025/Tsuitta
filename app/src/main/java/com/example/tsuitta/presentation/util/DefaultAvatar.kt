package com.example.tsuitta.presentation.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun DefaultAvatar(
    avatarUrl: String?,
    modifier: Modifier = Modifier
) {
    if (avatarUrl.isNullOrBlank()) {
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "avatar",
            modifier = modifier,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    } else {
        AsyncImage(
            model = avatarUrl,
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = modifier,
            placeholder = rememberVectorPainter(
                image = Icons.Filled.AccountCircle,
            )
        )
    }
}