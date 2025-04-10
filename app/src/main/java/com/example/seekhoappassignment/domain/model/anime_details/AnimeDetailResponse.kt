package com.example.seekhoappassignment.domain.model.anime_details

import com.google.gson.annotations.SerializedName

data class AnimeDetailResponse(
  @SerializedName("data") var data: AnimeDetail? = AnimeDetail(),
)