package com.example.movies.model.repositories

import com.example.movies.model.interfaces.IMovieApi
import com.example.movies.model.interfaces.IMovieDao
import com.example.movies.model.dataclasses.Movie
import com.example.movies.model.retrofit.movie.MovieNetworkEntity
import com.example.movies.model.retrofit.movie.MovieNetworkMapper
import com.example.movies.model.room.movie.MovieCacheMapper
import com.example.movies.model.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepository
constructor(
    private val movieDao: IMovieDao,
    private val movieService: IMovieApi,
    private val movieCacheMapper: MovieCacheMapper,
    private val movieNetworkMapper: MovieNetworkMapper,
    private val apiKey: String
){

    private val PAGES: Int = 5
    private val YEAR: String  = "2014"

    suspend fun getMovie(): Flow<DataState<List<Movie>>> = flow{
        emit(DataState.Loading)
        try {
            val networkMovies = mutableListOf<MovieNetworkEntity>()

            for(index in 1..PAGES)
            {
                networkMovies.addAll (movieService.getMovies(apiKey, YEAR, index.toString()).movies)
            }

            val movies = movieNetworkMapper.mapFromEntityList(networkMovies.toList())
            for (movie in movies){
                movieDao.insert(movieCacheMapper.mapToEntity(movie))
            }
            val cachedMovies = movieDao.getMovies()

            emit(DataState.Success(movieCacheMapper.mapFromEntityList(cachedMovies)))
        }
        catch (ex: Exception){
            emit(DataState.Error(ex))
        }
    }
}