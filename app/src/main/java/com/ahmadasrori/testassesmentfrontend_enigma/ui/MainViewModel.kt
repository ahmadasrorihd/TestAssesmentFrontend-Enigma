package com.ahmadasrori.testassesmentfrontend_enigma.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmadasrori.testassesmentfrontend_enigma.data.Repository
import com.ahmadasrori.testassesmentfrontend_enigma.model.MovieDetail
import com.ahmadasrori.testassesmentfrontend_enigma.model.genre.Genre
import com.ahmadasrori.testassesmentfrontend_enigma.model.movie.Movie
import com.ahmadasrori.testassesmentfrontend_enigma.model.review.Review
import com.ahmadasrori.testassesmentfrontend_enigma.model.trailer.TrailerVideo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(val repository: Repository) : ViewModel() {

    val genre = MutableLiveData<List<Genre>>()
    val movie = MutableLiveData<List<Movie>>()
    val review = MutableLiveData<List<Review>>()
    val trailer = MutableLiveData<List<TrailerVideo>>()
    val movieDetail = MutableLiveData<MovieDetail>()
    val errorMessage = MutableLiveData<String>()

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun getGenre() {
        compositeDisposable.add(
            repository.getGenre()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    val response = it
                    val data = response.genre
                    genre.postValue(data)
                }
        )
    }

    fun getMovie(genreId :Int?, page: Int?) {
        compositeDisposable.add(
            repository.getMovie(genreId, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    val response = it
                    val data = response.result
                    movie.postValue(data)
                }
        )
    }

    fun getDetailMovie(movieId :Int?) {
        compositeDisposable.add(
            repository.getDetailMovie(movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    val response = it
                    movieDetail.postValue(response)
                }
        )
    }

    fun getReview(movieId: Int?) {
        compositeDisposable.add(
            repository.getReviews(movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    val response = it
                    val data = response.result
                    review.postValue(data)
                }, {
                    errorMessage.postValue(it.localizedMessage)
                })
        )
    }

    fun getTrailer(movieId: Int?) {
        compositeDisposable.add(
            repository.getTrailerVideo(movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    val response = it
                    val data = response.result
                    trailer.postValue(data)
                }, {
                    errorMessage.postValue(it.localizedMessage)
                })
        )
    }

}