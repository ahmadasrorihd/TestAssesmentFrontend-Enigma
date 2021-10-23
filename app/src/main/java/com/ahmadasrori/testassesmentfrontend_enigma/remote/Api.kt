package com.ahmadasrori.testassesmentfrontend_enigma.remote;

import com.ahmadasrori.testassesmentfrontend_enigma.model.MovieDetail
import com.ahmadasrori.testassesmentfrontend_enigma.model.genre.GenreResponse
import com.ahmadasrori.testassesmentfrontend_enigma.model.movie.MovieResponse
import com.ahmadasrori.testassesmentfrontend_enigma.model.review.ReviewResponse
import com.ahmadasrori.testassesmentfrontend_enigma.model.trailer.TrailerVideoResponse
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("genre/movie/list")
    fun getGenre(
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") lang: String = Constant.LANGUAGE
    ): Observable<GenreResponse>

    @GET("discover/movie")
    fun getMovie(
        @Query("with_genre") genreId: Int?,
        @Query("page") page: Int?,
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): Observable<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movie: Int?,
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") lang: String = Constant.LANGUAGE
    ): Observable<MovieDetail>

    @GET("movie/{movie_id}/reviews")
    fun getReview(
        @Path("movie_id") movieId: Int?,
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") lang: String = Constant.LANGUAGE
    ): Observable<ReviewResponse>

    @GET("movie/{movie_id}/videos")
    fun getTrailerVideo(
        @Path("movie_id") movieId: Int?,
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") lang: String = Constant.LANGUAGE
    ): Observable<TrailerVideoResponse>
}
