package com.example.tsuitta.data.remote

import com.example.tsuitta.data.remote.model.UserApiModel
import retrofit2.http.GET

interface UserApi {

    @GET("/api/users")
    suspend fun getUsers(): List<UserApiModel>
}