package com.example.seekhoappassignment.presentation.anime_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.seekhoappassignment.databinding.FragmentAnimeListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeListFragment : Fragment() {

    private var binding: FragmentAnimeListBinding? = null
    private val viewModel: AnimeListViewModel by viewModels()
    private val animeAdapter by lazy {
        AnimeAdapter(navigateToAnimeDetailScreen)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
    }

    private fun initializeUI() {
        binding?.rvAnimeList?.apply {
            adapter = animeAdapter.withLoadStateHeaderAndFooter(
                header = AnimeLoadStateAdapter { animeAdapter.retry() },
                footer = AnimeLoadStateAdapter { animeAdapter.retry() }
            )
            layoutManager = GridLayoutManager(requireContext(), 2)
        }


        lifecycleScope.launch {
            viewModel.animeFlow.collectLatest {
                Log.d(TAG, "initializeUI: $it")
                animeAdapter.submitData(it)
            }
        }

        animeAdapter.addLoadStateListener { loadState ->
            binding?.progress?.isVisible = loadState.source.refresh is LoadState.Loading
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val TAG = "AnimeListFragment"
    }

    private val navigateToAnimeDetailScreen: (String) -> Unit = { animeId ->
        val action =
            AnimeListFragmentDirections.actionAnimeListFragmentToAnimeDetailFragment(animeId)
        findNavController().navigate(action)
    }

}