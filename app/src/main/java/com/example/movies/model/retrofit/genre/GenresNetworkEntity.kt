package com.example.movies.model.retrofit.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GenresNetworkEntity(
    @SerializedName("genres")
    @Expose
    var genres: List<GenreNetworkEntity>

    ){
}