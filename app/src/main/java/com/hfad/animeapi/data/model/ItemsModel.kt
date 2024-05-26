package com.hfad.animeapi.data.model


import com.google.gson.annotations.SerializedName

data class ItemsModel(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("per_page")
    val perPage: Int? = 0,
    @SerializedName("total")
    val total: Int? = 0
)