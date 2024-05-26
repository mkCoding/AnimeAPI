package com.hfad.animeapi.data.model


import com.google.gson.annotations.SerializedName

data class JpgModel(
    @SerializedName("image_url")
    val imageUrl: String? = ""
)