package com.example.tsuitta.presentation.tweets.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.tsuitta.domain.model.Tweet
import com.example.tsuitta.presentation.util.DefaultAvatar
import java.time.format.DateTimeFormatter

@Composable
fun TweetItem(
    tweet: Tweet
) {
    Row(
        modifier = Modifier
            .clickable { }
            .fillMaxWidth()
    ) {
        DefaultAvatar(
            avatarUrl = tweet.user.avatarUrl,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
                .clip(CircleShape)
                .size(40.dp)
        )
        Column(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 0.dp,
                    end = 24.dp,
                    bottom = 8.dp
                )
        ) {
            Text(
                text = tweet.user.name,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                lineHeight = MaterialTheme.typography.bodyMedium.lineHeight,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "@${tweet.user.email}・${
                    tweet.createdAt.format(
                        DateTimeFormatter.ofLocalizedDateTime(
                            java.time.format.FormatStyle.SHORT
                        )
                    )
                }",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                lineHeight = MaterialTheme.typography.bodySmall.lineHeight,
                fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = tweet.content,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                lineHeight = MaterialTheme.typography.bodyMedium.lineHeight,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val liked = remember { mutableStateOf(false) }

                    IconButton(
                        onClick = { liked.value = !liked.value },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            imageVector = if (liked.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = "",
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "返信")
                    }
                }
            }
        }
    }
}