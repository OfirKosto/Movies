package com.example.movies.repositories

import com.example.movies.interfaces.IGenreDao
import com.example.movies.interfaces.IGenreApi
import com.example.movies.model.Genre
import com.example.movies.retrofit.genre.GenreNetworkMapper
import com.example.movies.room.genre.GenreCacheMapper
import com.example.movies.util.DataState
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow

class GenreRepository
constructor(
    private val genreDao: IGenreDao,
    private val genreService: IGenreApi,
    private val genreCacheMapper: GenreCacheMapper,
    private val genreNetworkMapper: GenreNetworkMapper,
    private val apiKey: String
){
    suspend fun getGenre(): Flow<DataState<List<Genre>>> = flow{
        emit(DataState.Loading)
        try {
            val networkGenres = genreService.getGenres(apiKey)
            val genres = genreNetworkMapper.mapFromEntityList(networkGenres.genres)
            for (genre in genres){
                genreDao.insert(genreCacheMapper.mapToEntity(genre))
            }
            val cachedGenres = genreDao.getGeneres()
            emit(DataState.Success(genreCacheMapper.mapFromEntityList(cachedGenres)))
        }
        catch (ex: Exception){
            emit(DataState.Error(ex))
        }
    }
}