package com.ahmadasrori.testassesmentfrontend_enigma.model.trailer

import com.google.gson.annotations.SerializedName

data class TrailerVideo(
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("site")
    val site: String
)
