package com.example.seekhoappassignment.presentation.anime_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.seekhoappassignment.R
import com.example.seekhoappassignment.databinding.FragmentAnimeDetailBinding
import com.example.seekhoappassignment.domain.model.anime_details.AnimeDetail
import com.example.seekhoappassignment.utils.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeDetailFragment : Fragment() {

    private var binding: FragmentAnimeDetailBinding? = null
    private val viewModel: AnimeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        getBundleData()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
    }

    private fun getBundleData() {
        val args: AnimeDetailFragmentArgs by navArgs()
        val animeId = args.animeId
        Log.d(TAG, "Received string: $animeId")
        viewModel.fetchAnimeDetail(animeId)
    }

    private fun initializeViews() {
        binding?.apply {
            lifecycleScope.launch {
                viewModel.animeDetailState.collect { state ->
                    when (state) {
                        is UiState.Loading -> {
                            progress.isVisible = true
                            contentGroup.isVisible = false
                        }

                        is UiState.Success -> {
                            progress.isVisible = false
                            contentGroup.isVisible = true

                            setUpData(state.data)
                        }

                        is UiState.Error -> {
                            progress.isVisible = false
                            contentGroup.isVisible = false
                            Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }

    private fun setUpData(animeDetail: AnimeDetail) {
        binding?.apply {
            tvAnimeName.text = animeDetail.title
            tvAnimeDesc.text = animeDetail.synopsis
            tvAnimeEpisode.text = resources.getString(
                R.string.episode_count,
                animeDetail.episodes?.toString() ?: "N/A"
            )
            tvAnimeGenre.text = getString(
                R.string.label_genre,
                animeDetail.genres.joinToString(", ") { it.name.toString() }
            )

            tvAnimeRating.text = getString(
                R.string.label_rating,
                animeDetail.rating ?: "N/A"
            )

            Glide.with(requireContext()).load(animeDetail.images?.jpg?.largeImageUrl)
                .into(animeImage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val TAG = "AnimeDetailFragment"
    }
}