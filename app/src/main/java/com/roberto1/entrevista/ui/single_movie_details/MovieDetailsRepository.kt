package com.roberto1.entrevista.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.roberto1.entrevista.data.data.api.TheMovieDBInterface
import com.roberto1.entrevista.data.repository.MovieDetailsNetworkDataSource
import com.roberto1.entrevista.data.repository.NetworkState
import com.roberto1.entrevista.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }

}