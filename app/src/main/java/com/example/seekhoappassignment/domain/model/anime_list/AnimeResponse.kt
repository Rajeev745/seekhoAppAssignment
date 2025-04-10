package com.example.seekhoappassignment.domain.model.anime_list

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data") var data: ArrayList<Data> = arrayListOf(),
)