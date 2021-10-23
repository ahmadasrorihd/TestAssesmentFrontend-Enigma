package com.ahmadasrori.testassesmentfrontend_enigma.model.movie

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val original_title: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("release_date")
    val release_date: String
)
