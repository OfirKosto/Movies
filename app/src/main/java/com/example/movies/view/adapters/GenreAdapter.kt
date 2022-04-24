package com.example.movies.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import kotlinx.android.synthetic.main.genre_card.view.*

class GenreAdapter(var genres: List<String>): RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    class GenreViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.genre_card, parent, false)
        return GenreAdapter.GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.view.genre_name.setText(genres[position])
    }

    override fun getItemCount(): Int {
        return genres.size
    }


}