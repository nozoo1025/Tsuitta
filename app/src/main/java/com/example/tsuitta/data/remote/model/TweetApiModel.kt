package com.example.tsuitta.data.remote.model


import com.google.gson.annotations.SerializedName

data class TweetApiModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("content")
    val content: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user")
    val user: UserApiModel
)