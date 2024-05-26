package com.hfad.animeapi.data.model


import com.google.gson.annotations.SerializedName

data class WebpModel(
    @SerializedName("image_url")
    val imageUrl: String? = "",
    @SerializedName("small_image_url")
    val smallImageUrl: String? = ""
)