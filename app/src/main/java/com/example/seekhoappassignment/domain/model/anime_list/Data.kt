package com.example.seekhoappassignment.domain.model.anime_list

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("images") var images: Images? = Images(),
    @SerializedName("title") var title: String? = null,
    @SerializedName("title_english") var titleEnglish: String? = null,
    @SerializedName("title_japanese") var titleJapanese: String? = null,
    @SerializedName("title_synonyms") var titleSynonyms: ArrayList<String> = arrayListOf(),
    @SerializedName("type") var type: String? = null,
    @SerializedName("source") var source: String? = null,
    @SerializedName("episodes") var episodes: Int? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("airing") var airing: Boolean? = null,
    @SerializedName("duration") var duration: String? = null,
    @SerializedName("rating") var rating: String? = null,
    @SerializedName("score") var score: Double? = null,
    @SerializedName("scored_by") var scoredBy: Int? = null,
    @SerializedName("rank") var rank: Int? = null,
    @SerializedName("popularity") var popularity: Int? = null,
    @SerializedName("members") var members: Int? = null,
    @SerializedName("favorites") var favorites: Int? = null,
    @SerializedName("synopsis") var synopsis: String? = null,
    @SerializedName("background") var background: String? = null,
    @SerializedName("season") var season: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("explicit_genres") var explicitGenres: ArrayList<String> = arrayListOf(),
)