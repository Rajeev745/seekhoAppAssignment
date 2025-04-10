package com.example.seekhoappassignment.data.remote

import com.example.seekhoappassignment.domain.model.anime_details.AnimeDetailResponse
import com.example.seekhoappassignment.domain.model.anime_list.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("top/anime")
    suspend fun getTopAnime(@Query("page") page: Int): AnimeResponse

    @GET("anime/{id}")
    suspend fun getAnimeDetail(
        @Path("id") animeId: String
    ): AnimeDetailResponse
}