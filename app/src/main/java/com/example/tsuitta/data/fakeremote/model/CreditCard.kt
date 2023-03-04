package com.example.tsuitta.data.fakeremote.model


import com.google.gson.annotations.SerializedName

data class CreditCard(
    @SerializedName("cc_number")
    val ccNumber: String
)