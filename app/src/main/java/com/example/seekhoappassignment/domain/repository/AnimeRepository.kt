package com.example.seekhoappassignment.domain.repository

import androidx.paging.Pager
import com.example.seekhoappassignment.domain.model.anime_list.Data

interface AnimeRepository {

    fun getAnimeList(): Pager<Int, Data>

    fun getAnimeDetails(): Data
}