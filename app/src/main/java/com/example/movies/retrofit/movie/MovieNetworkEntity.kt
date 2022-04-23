package com.example.movies.retrofit.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieNetworkEntity(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("release_date")
    @Expose
    var releaseDate: String,

    @SerializedName("genre_ids")
    @Expose
    var genres: List<Int>

) {}