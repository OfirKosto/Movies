package com.example.movies.model.room.genre

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movies.model.interfaces.IGenreDao

@Database(entities = [GenreCacheEntity::class], version = 1)
abstract class GenreDatabase: RoomDatabase() {

    abstract fun genreDao(): IGenreDao

    companion object{
        val DATABASE_NAME: String = "genre_db"
    }
}