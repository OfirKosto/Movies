package com.example.movies.room.movie

import androidx.room.TypeConverter

class GenresConverter {

    @TypeConverter
    fun genresListToString(genresList: MutableList<Int>?): String? =
        genresList?.map { it.toString() }?.joinToString(separator = ",")

    @TypeConverter
    fun stringToGenresList(genresString: String?): MutableList<Int>? =
        genresString?.split(",")?.map { it.toInt() }?.toMutableList()
}