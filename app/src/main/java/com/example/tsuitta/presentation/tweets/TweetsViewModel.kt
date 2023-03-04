package com.example.tsuitta.presentation.tweets

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tsuitta.domain.usecase.tweet.TweetUseCases
import com.example.tsuitta.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(
    private val tweetUseCases: TweetUseCases
) : ViewModel() {

    var state = mutableStateOf(TweetUiState())
        private set

    init {
        getTweets()
    }

    private fun getTweets() {
        tweetUseCases.getTweets()
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        state.value = TweetUiState(tweets = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        state.value =
                            TweetUiState(error = result.message ?: "Unexpected Error Occurred")
                    }
                    is Resource.Loading -> {
                        state.value = TweetUiState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
    }
}