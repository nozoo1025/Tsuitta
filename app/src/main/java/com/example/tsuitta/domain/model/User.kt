package com.example.tsuitta.domain.model

data class User(
    val id: Int,
    val name: String,
    val bio: String?,
    val email: String,
    val avatarUrl: String?
)
