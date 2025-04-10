package com.example.seekhoappassignment.presentation.anime_list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.seekhoappassignment.R
import com.example.seekhoappassignment.databinding.ItemAnimeCardLayoutBinding
import com.example.seekhoappassignment.domain.model.anime_list.Data

class AnimeAdapter(private val navigateToAnimeDetailScreen: (String) -> Unit) :
    PagingDataAdapter<Data, AnimeAdapter.AnimeViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AnimeViewHolder {
        return AnimeViewHolder(
            ItemAnimeCardLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = getItem(position)
        holder.bind(anime)
        holder.binding.root.setOnClickListener {
            navigateToAnimeDetailScreen(anime?.malId.toString())
        }
    }

    class AnimeViewHolder(val binding: ItemAnimeCardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(anime: Data?) {
            binding.apply {
                Log.d(TAG, "bind: ${anime?.images?.jpg?.imageUrl}")
                tvAnimeName.text = anime?.title
                Glide.with(animeImage.context)
                    .load(anime?.images?.jpg?.imageUrl)
                    .into(animeImage)

                val episodeText = tvAnimeEpisodes.context.getString(
                    R.string.episode_count,
                    anime?.episodes?.toString() ?: "N/A"
                )

                tvAnimeEpisodes.text = episodeText
                tvAnimeRatings.text = anime?.rating
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data) =
                oldItem.malId == newItem.malId

            override fun areContentsTheSame(oldItem: Data, newItem: Data) = oldItem == newItem
        }

        const val TAG = "AnimeAdapter"
    }
}
