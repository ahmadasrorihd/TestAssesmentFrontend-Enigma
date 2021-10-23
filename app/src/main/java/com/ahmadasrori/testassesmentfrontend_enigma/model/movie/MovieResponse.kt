package com.ahmadasrori.testassesmentfrontend_enigma.model.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var result: List<Movie>? = null
)