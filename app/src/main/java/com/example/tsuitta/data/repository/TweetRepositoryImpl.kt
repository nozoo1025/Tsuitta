package com.example.tsuitta.data.repository

import com.example.tsuitta.data.mapper.toTweet
import com.example.tsuitta.data.remote.TweetApi
import com.example.tsuitta.domain.model.Tweet
import com.example.tsuitta.domain.repository.TweetRepository
import com.example.tsuitta.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject

class TweetRepositoryImpl @Inject constructor(
    private val api: TweetApi
) : TweetRepository {

    override fun getTweetsFlow(): Flow<Resource<List<Tweet>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val tweets = api.getTweets()
                emit(Resource.Success(tweets.map { it.toTweet() }))
            } catch (e: HttpException) {
                emit(Resource.Error("Unexpected error occurred."))
                e.printStackTrace()
            } catch (e: Exception) {
                emit(Resource.Error("Failed to connect to the server. Please check your device's connection."))
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }
}