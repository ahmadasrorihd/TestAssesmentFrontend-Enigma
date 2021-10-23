package com.ahmadasrori.testassesmentfrontend_enigma.model.review

import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("id")
    val id: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("created_at")
    val created_at: String
)
