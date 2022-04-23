package com.example.movies.di

import com.example.movies.interfaces.IGenreDao
import com.example.movies.interfaces.IGenreApi
import com.example.movies.interfaces.IMovieApi
import com.example.movies.interfaces.IMovieDao
import com.example.movies.repositories.GenreRepository
import com.example.movies.repositories.MovieRepository
import com.example.movies.retrofit.genre.GenreNetworkMapper
import com.example.movies.retrofit.movie.MovieNetworkMapper
import com.example.movies.room.genre.GenreCacheMapper
import com.example.movies.room.movie.MovieCacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGenreRepository(
        genreDao: IGenreDao,
        genreService: IGenreApi,
        genreCacheMapper: GenreCacheMapper,
        genreNetworkMapper: GenreNetworkMapper,
        apiKey: String
    ): GenreRepository{
        return GenreRepository(genreDao, genreService, genreCacheMapper, genreNetworkMapper, apiKey)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieDao: IMovieDao,
        movieService: IMovieApi,
        movieCacheMapper: MovieCacheMapper,
        movieNetworkMapper: MovieNetworkMapper,
        apiKey: String
    ): MovieRepository{
        return MovieRepository(movieDao, movieService, movieCacheMapper, movieNetworkMapper, apiKey)
    }
}