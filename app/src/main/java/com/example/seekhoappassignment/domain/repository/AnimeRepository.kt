package com.example.seekhoappassignment.domain.repository

import androidx.paging.Pager
import com.example.seekhoappassignment.domain.model.anime_details.AnimeDetail
import com.example.seekhoappassignment.domain.model.anime_details.AnimeDetailResponse
import com.example.seekhoappassignment.domain.model.anime_list.Data

interface AnimeRepository {

    fun getAnimeList(): Pager<Int, Data>

    suspend fun getAnimeDetails(animeId: String): AnimeDetail?
}