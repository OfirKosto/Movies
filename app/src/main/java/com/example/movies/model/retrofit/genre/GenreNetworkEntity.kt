package com.example.movies.model.retrofit.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GenreNetworkEntity(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String
) {
}