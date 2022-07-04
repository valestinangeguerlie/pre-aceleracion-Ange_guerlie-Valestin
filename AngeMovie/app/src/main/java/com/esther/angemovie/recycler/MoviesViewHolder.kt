package com.esther.angemovie.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.esther.angemovie.Configuration
import com.esther.angemovie.ResultsMoviesResponse
import com.esther.angemovie.databinding.ActivityMainBinding
import com.esther.angemovie.databinding.MovieItemBinding
import com.squareup.picasso.Picasso

class MoviesViewHolder(
    view: View,
    private val clickListener: MoviesAdapter.ClickListener,
    movies: List<ResultsMoviesResponse>

) : RecyclerView.ViewHolder(view) {
    private val binding = MovieItemBinding.bind(view)
    fun bind(movies: ResultsMoviesResponse){
        Picasso.get().load(Configuration.IMAGE_URL + movies.posterPath).into(binding.ivPosterMovies)
        binding.tvTitleMovie.text = movies.originalTitle
    }

    init {
        itemView.setOnClickListener {
            clickListener.onItemClick(adapterPosition, movies)
        }
    }
}