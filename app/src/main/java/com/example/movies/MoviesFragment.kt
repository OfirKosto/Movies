package com.example.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.adapters.MovieAdapter
import com.example.movies.model.Genre
import com.example.movies.model.Movie
import com.example.movies.util.DataState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.movies_fragment.*
import java.lang.StringBuilder
import java.util.*

@AndroidEntryPoint
class MoviesFragment() : Fragment(R.layout.movies_fragment) {

    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var genresMap: MutableMap<Int, String>
    private lateinit var adapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeObservers()
        viewModel.getGenres()
    }

    private fun subscribeObservers(){
        viewModel.genreDataState.observe(viewLifecycleOwner, Observer { dataState->
            when(dataState){
                is DataState.Success<List<Genre>> -> {
                    displayProgressBar(true)
                    initGeneresHashtable(dataState.data)
                    viewModel.getMovies()
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }

            }
        })

        viewModel.movieDataState.observe(viewLifecycleOwner, Observer { dataState->
            when(dataState){
                is DataState.Success<List<Movie>> -> {
                    displayProgressBar(false)
                    initRecyclerview(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }

            }
        })
    }

    private fun initGeneresHashtable(data: List<Genre>) {
        genresMap = mutableMapOf<Int, String>()
        for(genre in data)
        {
            genresMap.put(genre.id, genre.name)
        }
    }

    private fun initRecyclerview(movies: List<Movie>) {
        adapter = MovieAdapter(context!!, movies, genresMap)
        movies_recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        movies_recyclerView.setHasFixedSize(true)
        movies_recyclerView.adapter = adapter
    }

    private fun displayError(message: String?){
        if(message != null)
        {
            Snackbar.make(this.view!!, message, Snackbar.LENGTH_LONG).show()
        }
        else
        {
            Snackbar.make(this.view!!, R.string.unknown_error, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean){
        progress_bar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }

}