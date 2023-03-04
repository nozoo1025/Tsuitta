package com.example.tsuitta.presentation.tweets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tsuitta.presentation.tweets.components.TweetItem
import com.example.tsuitta.presentation.util.SimpleAlertDialog

@Composable
fun TweetsScreen(
    viewModel: TweetsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    if (state.error.isNotBlank()) {
        SimpleAlertDialog(
            title = "Network Error",
            message = state.error,
            confirmText = "OK",
            onConfirmed = {
                // TODO
            }
        )
    }

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    if (state.tweets.isNotEmpty()) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        // TODO
                    },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add tweet"
                    )
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(
                        bottom = paddingValues.calculateBottomPadding()
                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {
                    Text(
                        text = "Tweets",
                        fontWeight = MaterialTheme.typography.displayMedium.fontWeight,
                        fontSize = MaterialTheme.typography.displayMedium.fontSize,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(state.tweets) { tweet ->
                        TweetItem(tweet = tweet)
                    }
                }
            }
        }
    }
}