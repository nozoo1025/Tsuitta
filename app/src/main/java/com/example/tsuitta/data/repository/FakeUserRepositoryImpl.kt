package com.example.tsuitta.data.repository

import com.example.tsuitta.data.fakeremote.FakeUserApi
import com.example.tsuitta.data.fakeremote.model.toUser
import com.example.tsuitta.domain.model.User
import com.example.tsuitta.domain.repository.UserRepository
import com.example.tsuitta.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject

class FakeUserRepositoryImpl @Inject constructor(
    private val fakeUserApi: FakeUserApi
) : UserRepository {

    override fun getUsersFlow(): Flow<Resource<List<User>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val users = fakeUserApi.getFakeUsers()
                emit(Resource.Success(users.map { it.toUser() }))
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