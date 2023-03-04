package com.example.tsuitta.data.remote

import com.example.tsuitta.data.remote.model.TweetApiModel
import retrofit2.http.GET

interface TweetApi {

    @GET("/api/tweets")
    suspend fun getTweets(): List<TweetApiModel>
}