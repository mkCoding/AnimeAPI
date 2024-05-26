package com.hfad.animeapi.data.model


import com.google.gson.annotations.SerializedName

data class PaginationModel(
    @SerializedName("current_page")
    val currentPage: Int? = 0,
    @SerializedName("has_next_page")
    val hasNextPage: Boolean? = false,
    @SerializedName("items")
    val items: ItemsModel? = ItemsModel(),
    @SerializedName("last_visible_page")
    val lastVisiblePage: Int? = 0
)