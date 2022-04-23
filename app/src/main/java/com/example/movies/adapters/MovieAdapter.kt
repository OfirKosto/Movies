package com.example.movies.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.model.Movie
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.android.synthetic.main.movie_card.view.*

class MovieAdapter(
    val context: Context,
    val moviesList: List<Movie>,
    val genresMap: Map<Int, String>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val currentMovie = moviesList[position]
        holder.view.title.setText(currentMovie.title)
        holder.view.date.setText(currentMovie.releaseDate)

        val genresNames = mutableListOf<String>()

        for (genre in currentMovie.genres)
        {
            if(genresMap.get(genre) != null)
            {
                genresNames.add(genresMap.get(genre)!!)
            }
        }

        val adapter = GenreAdapter(genresNames)
        val recyclerView = holder.view.genres_recyclerView

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


}