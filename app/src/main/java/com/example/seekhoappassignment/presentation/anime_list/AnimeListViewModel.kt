package com.example.seekhoappassignment.presentation.anime_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.seekhoappassignment.domain.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeListViewModel @Inject constructor(
    private val repository: AnimeRepository,
) : ViewModel() {

    companion object {
        const val TAG = "AnimeListViewModel"
    }

    val animeFlow = repository.getAnimeList()
        .flow
        .cachedIn(viewModelScope)
}