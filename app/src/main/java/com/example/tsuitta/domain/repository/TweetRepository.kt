package com.example.tsuitta.domain.repository

import com.example.tsuitta.domain.model.Tweet
import com.example.tsuitta.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface TweetRepository {

    fun getTweetsFlow(): Flow<Resource<List<Tweet>>>
}