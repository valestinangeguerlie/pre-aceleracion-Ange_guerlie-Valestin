package com.esther.angemovie

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Configuration {
    const val API_KEY = "35eb9c29a0c95136d779b4d99ac3371f"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

    fun getRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}