package com.roberto1.entrevista.data.data.api

import com.roberto1.entrevista.data.vo.MovieDetails
import com.roberto1.entrevista.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {
    // https://api.themoviedb.org/3/movie/popular?api_key=86cbedace2010b80127773f9553cc5b6&page=1
    // https://api.themoviedb.org/3/movie/299534?api_key=86cbedace2010b80127773f9553cc5b6
    // https://api.themoviedb.org/3/

    //obtener peliculas populares
    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    //obtener pelicula por id
    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>

}
