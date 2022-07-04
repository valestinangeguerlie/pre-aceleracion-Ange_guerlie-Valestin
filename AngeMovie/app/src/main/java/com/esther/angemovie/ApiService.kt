package com.esther.angemovie

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") api_key: String,
    ): Response<MoviesResponse<List<ResultsMoviesResponse>>>
}