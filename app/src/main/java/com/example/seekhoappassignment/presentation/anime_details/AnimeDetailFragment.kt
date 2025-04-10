package com.example.seekhoappassignment.presentation.anime_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.seekhoappassignment.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : Fragment() {

    private var binding: FragmentAnimeDetailBinding? = null

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
    }

    private fun initializeViews() {
        binding?.apply {

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