package com.ahmadasrori.testassesmentfrontend_enigma.model.genre

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
