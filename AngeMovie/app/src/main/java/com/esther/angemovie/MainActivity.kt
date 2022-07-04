package com.esther.angemovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.esther.angemovie.databinding.ActivityMainBinding
import com.esther.angemovie.recycler.MoviesAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity(), MoviesAdapter.ClickListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MoviesAdapter
    var movies = mutableListOf<ResultsMoviesResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMovies()
    }

    private fun getMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = Configuration.getRetroFit().create(ApiService::class.java)
                .getMovies("${Configuration.API_KEY}")
            val popularMovies = call.body()?.results ?: emptyList()
            runOnUiThread{
                if(call.isSuccessful && popularMovies.isNotEmpty()){
                    adapter = MoviesAdapter(popularMovies, this@MainActivity)
                    binding.rvMovies.adapter = adapter
                }
                else{
                    Toast.makeText(this@MainActivity, "Popular movies not found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onItemClick(position: Int, movies: List<ResultsMoviesResponse>) {
        val intent  = Intent(this, DetailsMovie::class.java)
        intent.putExtra("title", movies[position].originalTitle)
        intent.putExtra("image", movies[position].posterPath)
        intent.putExtra("overview", movies[position].overview)
        intent.putExtra("language", movies[position].originalLanguage)

        startActivity(intent)
    }



}