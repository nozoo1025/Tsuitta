package com.example.tsuitta.data.fakeremote.model


import com.google.gson.annotations.SerializedName

data class Subscription(
    @SerializedName("plan")
    val plan: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("payment_method")
    val paymentMethod: String,
    @SerializedName("term")
    val term: String
)