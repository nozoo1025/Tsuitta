package com.example.tsuitta.data.remote.model


import com.google.gson.annotations.SerializedName

data class UserApiModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)