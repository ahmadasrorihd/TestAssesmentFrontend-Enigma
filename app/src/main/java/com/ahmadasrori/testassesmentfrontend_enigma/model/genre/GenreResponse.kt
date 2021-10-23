package com.ahmadasrori.testassesmentfrontend_enigma.model.genre

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("genres")
    var genre: List<Genre>? = null
)
