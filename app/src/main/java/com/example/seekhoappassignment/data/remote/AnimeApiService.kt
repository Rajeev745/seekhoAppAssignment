package com.example.seekhoappassignment.data.remote

import com.example.seekhoappassignment.domain.model.anime_list.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("top/anime")
    suspend fun getTopAnime(@Query("page") page: Int): AnimeResponse
}