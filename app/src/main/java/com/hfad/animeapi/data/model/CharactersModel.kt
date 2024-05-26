package com.hfad.animeapi.data.model


import com.google.gson.annotations.SerializedName

data class CharactersModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("pagination")
    val pagination: PaginationModel? = PaginationModel()
)