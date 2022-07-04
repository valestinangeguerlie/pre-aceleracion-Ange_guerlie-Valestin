package com.esther.angemovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.esther.angemovie.databinding.ActivityDeatailsMovieBinding
import com.squareup.picasso.Picasso

class DetailsMovie : AppCompatActivity() {

    private lateinit var binding: ActivityDeatailsMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeatailsMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Picasso.get().load("${Configuration.IMAGE_URL}${this.intent.extras?.get("image").toString()}")
            .into(binding.imPoster)
        binding.tvTitle.text = this.intent.extras?.get("title").toString()
        binding.tvOverview.text = this.intent.extras?.get("overview").toString()
        binding.tvLanguage.text = this.intent.extras?.get("language").toString()
    }
}