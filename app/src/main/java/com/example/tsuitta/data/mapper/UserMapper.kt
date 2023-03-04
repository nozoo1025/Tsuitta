package com.example.tsuitta.data.mapper

import com.example.tsuitta.data.remote.model.UserApiModel
import com.example.tsuitta.domain.model.User

fun UserApiModel.toUser(): User {
    return User(
        id = id,
        name = name,
        bio = bio,
        email = email,
        avatarUrl = avatarUrl
    )
}