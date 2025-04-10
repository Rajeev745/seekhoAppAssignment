package com.example.seekhoappassignment.domain.model.anime_list

import com.google.gson.annotations.SerializedName


data class Images(
    @SerializedName("jpg") var jpg: Jpg? = null,
    @SerializedName("webp") var webp: Webp? = null,
)