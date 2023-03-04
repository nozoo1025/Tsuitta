package com.example.tsuitta.domain.model

import java.time.LocalDateTime

data class Tweet(
    val content: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val user: User
)
