package com.example.tsuitta.data.fakeremote.model


import com.google.gson.annotations.SerializedName

data class Employment(
    @SerializedName("title")
    val title: String,
    @SerializedName("key_skill")
    val keySkill: String
)