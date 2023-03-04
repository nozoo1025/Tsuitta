package com.example.tsuitta.domain.repository

import com.example.tsuitta.domain.model.User
import com.example.tsuitta.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsersFlow(): Flow<Resource<List<User>>>
}