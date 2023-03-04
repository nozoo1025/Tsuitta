package com.example.tsuitta.data.mapper

import com.example.tsuitta.data.remote.model.TweetApiModel
import com.example.tsuitta.domain.model.Tweet
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun TweetApiModel.toTweet(): Tweet {
    return Tweet(
        content = content,
        createdAt = LocalDateTime.parse(createdAt, DateTimeFormatter.ISO_DATE_TIME),
        updatedAt = LocalDateTime.parse(updatedAt, DateTimeFormatter.ISO_DATE_TIME),
        user = user.toUser()
    )
}