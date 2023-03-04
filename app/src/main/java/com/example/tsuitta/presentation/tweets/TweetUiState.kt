package com.example.tsuitta.presentation.tweets

import com.example.tsuitta.domain.model.Tweet

data class TweetUiState(
    val isLoading: Boolean = false,
    val tweets: List<Tweet> = emptyList(),
    val error: String = ""
)
