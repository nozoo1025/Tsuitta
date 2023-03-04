package com.example.tsuitta.domain.usecase.user

import com.example.tsuitta.domain.model.User
import com.example.tsuitta.domain.repository.UserRepository
import com.example.tsuitta.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke(): Flow<Resource<List<User>>> {
        return repository.getUsersFlow()
    }
}