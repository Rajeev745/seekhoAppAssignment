package com.example.seekhoappassignment.data.anime_paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.seekhoappassignment.data.remote.AnimeApiService
import com.example.seekhoappassignment.domain.model.anime_list.Data

class AnimePagingSource(
    private val api: AnimeApiService,
) : PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val page = params.key ?: 1
            val response = api.getTopAnime(page)
            LoadResult.Page(
                data = response.data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.data.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition
    }
}
