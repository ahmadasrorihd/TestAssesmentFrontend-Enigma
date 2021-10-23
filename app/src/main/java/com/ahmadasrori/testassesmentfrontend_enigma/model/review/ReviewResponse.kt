package com.ahmadasrori.testassesmentfrontend_enigma.model.review

import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var result: List<Review>? = null
)