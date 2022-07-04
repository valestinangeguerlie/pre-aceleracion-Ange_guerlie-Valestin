package com.esther.angemovie.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esther.angemovie.MainActivity
import com.esther.angemovie.R
import com.esther.angemovie.ResultsMoviesResponse

class MoviesAdapter(
    private val movies: List<ResultsMoviesResponse>,
    private val clickListener: MainActivity

) : RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MoviesViewHolder(view, clickListener, movies)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    interface ClickListener {
        fun onItemClick(position: Int, movies: List<ResultsMoviesResponse>)
    }
}

