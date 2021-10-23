package com.ahmadasrori.testassesmentfrontend_enigma.data

import com.ahmadasrori.testassesmentfrontend_enigma.model.MovieDetail
import com.ahmadasrori.testassesmentfrontend_enigma.model.genre.GenreResponse
import com.ahmadasrori.testassesmentfrontend_enigma.model.movie.MovieResponse
import com.ahmadasrori.testassesmentfrontend_enigma.model.review.ReviewResponse
import com.ahmadasrori.testassesmentfrontend_enigma.model.trailer.TrailerVideoResponse
import com.ahmadasrori.testassesmentfrontend_enigma.remote.Api
import io.reactivex.Observable

class Repository(val api: Api) {

    fun getGenre(): Observable<GenreResponse> {
        return api.getGenre()
    }

    fun getMovie(id: Int?, page: Int?): Observable<MovieResponse> {
        return api.getMovie(id, page)
    }

    fun getDetailMovie(id: Int?): Observable<MovieDetail> {
        return api.getMovieDetail(id)
    }

    fun getReviews(id: Int?): Observable<ReviewResponse> {
        return api.getReview(id)
    }

    fun getTrailerVideo(id: Int?): Observable<TrailerVideoResponse> {
        return api.getTrailerVideo(id)
    }

}