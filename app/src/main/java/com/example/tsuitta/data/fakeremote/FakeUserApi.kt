package com.example.tsuitta.data.fakeremote

import com.example.tsuitta.data.fakeremote.model.FakeUserApiModel
import retrofit2.http.GET

interface FakeUserApi {

    @GET("/api/v2/users?size=20")
    suspend fun getFakeUsers(): List<FakeUserApiModel>
}