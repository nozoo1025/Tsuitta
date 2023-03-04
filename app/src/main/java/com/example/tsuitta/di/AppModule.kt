package com.example.tsuitta.di

import com.example.tsuitta.data.fakeremote.FakeUserApi
import com.example.tsuitta.data.remote.TweetApi
import com.example.tsuitta.data.remote.UserApi
import com.example.tsuitta.data.repository.FakeUserRepositoryImpl
import com.example.tsuitta.data.repository.TweetRepositoryImpl
import com.example.tsuitta.data.repository.UserRepositoryImpl
import com.example.tsuitta.domain.repository.TweetRepository
import com.example.tsuitta.domain.repository.UserRepository
import com.example.tsuitta.domain.usecase.tweet.GetTweetsUseCase
import com.example.tsuitta.domain.usecase.tweet.TweetUseCases
import com.example.tsuitta.domain.usecase.user.GetUserUseCase
import com.example.tsuitta.domain.usecase.user.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserApi(): UserApi {
        return Retrofit.Builder()
            .baseUrl("http://172.31.80.1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTweetApi(): TweetApi {
        return Retrofit.Builder()
            .baseUrl("http://172.31.80.1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TweetApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFakeUserApi(): FakeUserApi {
        return Retrofit.Builder()
            .baseUrl("https://random-data-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeUserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideTweetRepository(api: TweetApi): TweetRepository {
        return TweetRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUsersUseCase(repository: UserRepository): UserUseCases {
        return UserUseCases(
            getUsers = GetUserUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideTweetsUseCase(repository: TweetRepository): TweetUseCases {
        return TweetUseCases(
            getTweets = GetTweetsUseCase(repository)
        )
    }
}