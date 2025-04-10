package com.example.seekhoappassignment.presentation.anime_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.seekhoappassignment.databinding.ItemAnimeStateLoaderBinding

class AnimeLoadStateAdapter(
    private val retry: () -> Unit,
) : LoadStateAdapter<AnimeLoadStateAdapter.LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = ItemAnimeStateLoaderBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return LoadStateViewHolder(binding, retry)
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class LoadStateViewHolder(
        private val binding: ItemAnimeStateLoaderBinding,
        retry: () -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.retryButton.setOnClickListener { retry.invoke() }
        }

        fun bind(loadState: LoadState) {
            binding.progressBar.isVisible = loadState is LoadState.Loading
            binding.errorMsg.isVisible = loadState is LoadState.Error
            binding.retryButton.isVisible = loadState is LoadState.Error

            if (loadState is LoadState.Error) {
                binding.errorMsg.text = loadState.error.localizedMessage
            }
        }
    }
}