package com.example.tsuitta.presentation.users.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tsuitta.domain.model.User
import com.example.tsuitta.presentation.util.DefaultAvatar

@Composable
fun UserItem(
    user: User
) {
    Row(
        modifier = Modifier
            .clickable { }
            .fillMaxWidth()
    ) {
        DefaultAvatar(
            avatarUrl = user.avatarUrl,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
                .clip(CircleShape)
                .size(40.dp)
        )
        Row(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 0.dp,
                    end = 24.dp,
                    bottom = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = user.name,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    lineHeight = MaterialTheme.typography.bodyLarge.lineHeight,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = user.email,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    lineHeight = MaterialTheme.typography.bodyMedium.lineHeight,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }


            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "フォロー")
            }
        }
    }
}