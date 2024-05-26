package com.hfad.animeapi.data.model


import com.google.gson.annotations.SerializedName

data class ImagesModel(
    @SerializedName("jpg")
    val jpg: JpgModel? = JpgModel(),
    @SerializedName("webp")
    val webp: WebpModel? = WebpModel()
)