package com.example.seekhoappassignment.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.seekhoappassignment.data.anime_paging_source.AnimePagingSource
import com.example.seekhoappassignment.data.remote.AnimeApiService
import com.example.seekhoappassignment.domain.model.anime_list.Data
import com.example.seekhoappassignment.domain.repository.AnimeRepository
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(private val api: AnimeApiService) : AnimeRepository {

    override fun getAnimeList(): Pager<Int, Data> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = { AnimePagingSource(api) }
        )
    }

    override fun getAnimeDetails(): Data {
        TODO("Not yet implemented")
    }
}