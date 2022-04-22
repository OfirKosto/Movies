package com.example.movies.di

import android.content.Context
import androidx.room.Room
import com.example.movies.interfaces.GenreDao
import com.example.movies.room.GenreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideGenreDb(@ApplicationContext context: Context): GenreDatabase{
        return Room.databaseBuilder(
            context,
            GenreDatabase::class.java,
            GenreDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideGenreDao(genreDatabase: GenreDatabase): GenreDao{
        return genreDatabase.genreDao()
    }
}