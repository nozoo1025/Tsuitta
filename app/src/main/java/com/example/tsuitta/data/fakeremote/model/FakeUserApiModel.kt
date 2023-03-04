package com.example.tsuitta.data.fakeremote.model


import com.example.tsuitta.domain.model.User
import com.google.gson.annotations.SerializedName

data class FakeUserApiModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("uid")
    val uid: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("social_insurance_number")
    val socialInsuranceNumber: String,
    @SerializedName("date_of_birth")
    val dateOfBirth: String,
    @SerializedName("employment")
    val employment: Employment,
    @SerializedName("address")
    val address: Address,
    @SerializedName("credit_card")
    val creditCard: CreditCard,
    @SerializedName("subscription")
    val subscription: Subscription
)

fun FakeUserApiModel.toUser(): User {
    return User(
        id = id,
        name = username,
        email = email,
        avatarUrl = avatar,
        bio = null
    )
}