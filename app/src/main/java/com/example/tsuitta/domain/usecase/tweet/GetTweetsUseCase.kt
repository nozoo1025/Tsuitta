package com.example.tsuitta.domain.usecase.tweet

import com.example.tsuitta.domain.model.Tweet
import com.example.tsuitta.domain.repository.TweetRepository
import com.example.tsuitta.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetTweetsUseCase @Inject constructor(
    private val repository: TweetRepository
) {

    operator fun invoke(): Flow<Resource<List<Tweet>>> {
        return repository.getTweetsFlow()
            .map { result ->
                if (result is Resource.Success) {
                    val tweets = result.data
                    Resource.Success(
                        tweets
                            ?.map { tweet ->
                                tweet.copy(
                                    user = tweet.user.copy(
                                        email = tweet.user.email
                                            .replaceAfter("@", "")
                                            .replace("@", "")
                                    )
                                )
                            }
                            ?.sortedByDescending { it.createdAt }
                    )
                } else {
                    result
                }
            }
    }
}