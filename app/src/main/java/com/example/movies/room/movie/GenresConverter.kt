package com.example.movies.room.movie

import androidx.room.TypeConverter

class GenresConverter {

    @TypeConverter
    fun genresToInt(genres: MutableList<Int>?): String? =
        genres?.map { it.toString() }?.joinToString(separator = ",")

    @TypeConverter
    fun stringToDaysOfWeek(genres: String?): MutableList<Int>? =
        genres?.split(",")?.map { it.toInt() }?.toMutableList()
}