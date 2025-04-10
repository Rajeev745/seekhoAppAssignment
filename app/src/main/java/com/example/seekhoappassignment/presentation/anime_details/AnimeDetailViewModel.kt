package com.example.seekhoappassignment.presentation.anime_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoappassignment.domain.model.anime_details.AnimeDetail
import com.example.seekhoappassignment.domain.repository.AnimeRepository
import com.example.seekhoappassignment.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

    private val _animeDetailState = MutableStateFlow<UiState<AnimeDetail>>(UiState.Loading)
    val animeDetailState: StateFlow<UiState<AnimeDetail>> = _animeDetailState.asStateFlow()

    fun fetchAnimeDetail(animeId: String) {
        viewModelScope.launch {
            _animeDetailState.value = UiState.Loading
            try {
                val detail = repository.getAnimeDetails(animeId)
                _animeDetailState.value = UiState.Success(detail) as UiState<AnimeDetail>
            } catch (e: Exception) {
                _animeDetailState.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}