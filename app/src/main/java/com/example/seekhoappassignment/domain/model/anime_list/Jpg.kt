package com.example.seekhoappassignment.domain.model.anime_list

import com.google.gson.annotations.SerializedName

data class Jpg(
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("small_image_url") var smallImageUrl: String? = null,
    @SerializedName("medium_image_url") var mediumImageUrl: String? = null,
    @SerializedName("large_image_url") var largeImageUrl: String? = null,
    @SerializedName("maximum_image_url") var maximumImageUrl: String? = null,
)