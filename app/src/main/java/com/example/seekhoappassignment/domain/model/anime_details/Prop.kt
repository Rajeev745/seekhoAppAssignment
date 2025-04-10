package com.example.seekhoappassignment.domain.model.anime_details

import com.google.gson.annotations.SerializedName

data class Prop (
    @SerializedName("from" ) var from : From? = From(),
    @SerializedName("to"   ) var to   : To?   = To()
)