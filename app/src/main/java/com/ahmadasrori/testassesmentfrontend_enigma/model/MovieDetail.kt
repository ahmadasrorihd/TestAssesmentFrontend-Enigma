package com.ahmadasrori.testassesmentfrontend_enigma.model

import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val original_title: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("vote_average")
    val vote_average: String
)
