package com.hfad.animeapi.data.model


import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("about")
    val about: String? = "",
    @SerializedName("favorites")
    val favorites: Int? = 0,
    @SerializedName("images")
    val images: ImagesModel? = ImagesModel(),
    @SerializedName("mal_id")
    val malId: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("name_kanji")
    val nameKanji: String? = "",
    @SerializedName("nicknames")
    val nicknames: List<String?>? = listOf(),
    @SerializedName("url")
    val url: String? = ""
)