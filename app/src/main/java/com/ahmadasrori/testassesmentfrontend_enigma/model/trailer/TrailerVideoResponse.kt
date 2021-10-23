package com.ahmadasrori.testassesmentfrontend_enigma.model.trailer

import com.google.gson.annotations.SerializedName

data class TrailerVideoResponse(
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var result: List<TrailerVideo>? = null
)