package com.ahmadasrori.testassesmentfrontend_enigma.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadasrori.testassesmentfrontend_enigma.adapter.ReviewAdapter
import com.ahmadasrori.testassesmentfrontend_enigma.adapter.TrailerAdapter
import com.ahmadasrori.testassesmentfrontend_enigma.databinding.ActivityMovieDetailBinding
import com.ahmadasrori.testassesmentfrontend_enigma.model.review.Review
import com.ahmadasrori.testassesmentfrontend_enigma.model.trailer.TrailerVideo
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant.BUNDLE.MOVIE_ID
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant.URL_IMAGE
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import org.koin.android.viewmodel.ext.android.viewModel

class MovieDetailActivity : AppCompatActivity() {

    private val binding: ActivityMovieDetailBinding by lazy {
        ActivityMovieDetailBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()
    private val listReview = ArrayList<Review>()
    private val listTrailer = ArrayList<TrailerVideo>()
    private var movieId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val args = intent.extras
        movieId = args?.getInt(MOVIE_ID)

        observe()
        viewModel.getDetailMovie(movieId)
        viewModel.getReview(movieId)
        viewModel.getTrailer(movieId)
    }

    private fun observe(){
        viewModel.movieDetail.observe(this, {
            binding.movieDetail = it
            Glide.with(this)
                .load("$URL_IMAGE${it.poster_path}")
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.ivMovie)
        })

        viewModel.review.observe(this, {
            it.let {
                listReview.addAll(it)
                initListReview()
            }
        })
        viewModel.trailer.observe(this, {
            it.let {
                listTrailer.addAll(it)
                initListTrailer()
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initListReview() {
        val adapter = ReviewAdapter(listReview) {

        }
        binding.rvItemReview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvItemReview.adapter = adapter
        binding.rvItemReview.isNestedScrollingEnabled = false
        binding.rvItemReview.adapter?.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initListTrailer() {
        val adapter = TrailerAdapter(this, listTrailer) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(Constant.URL_YOUTUBE+listTrailer[it].key)))
        }
        binding.rvItemTrailer.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvItemTrailer.adapter = adapter
        binding.rvItemTrailer.isNestedScrollingEnabled = false
        binding.rvItemTrailer.adapter?.notifyDataSetChanged()
    }
}