package com.ahmadasrori.testassesmentfrontend_enigma.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmadasrori.testassesmentfrontend_enigma.adapter.MovieAdapter
import com.ahmadasrori.testassesmentfrontend_enigma.databinding.ActivityMovieBinding
import com.ahmadasrori.testassesmentfrontend_enigma.model.movie.Movie
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant.BUNDLE.MOVIE_ID
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant.PAGE
import org.koin.android.viewmodel.ext.android.viewModel




class MovieActivity : AppCompatActivity() {

    private val binding: ActivityMovieBinding by lazy {
        ActivityMovieBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()
    private val listMovie = ArrayList<Movie>()
    private var genreId: Int? = null
    private var genreName: String? = null
    private var isLoadMoreEnable = false
    private val recyclerViewState: Parcelable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val args = intent.extras
        genreId = args?.getInt(Constant.BUNDLE.GENRE_ID)
        genreName = args?.getString(Constant.BUNDLE.GENRE_NAME)

        binding.tvTitle.text = "List Movie of "+genreName
        observe()
        viewModel.getMovie(genreId, PAGE)
    }

    private fun observe(){
        viewModel.movie.observe(this, {
            if (PAGE==1) {
                listMovie.clear()
                listMovie.addAll(it)
            } else {
                listMovie.addAll(it)

            }
            initList()
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initList() {
        val adapter = MovieAdapter(this, listMovie) {
            val intent = Intent(this, MovieDetailActivity::class.java).apply {
                val bundle = Bundle().apply {
                    putInt(MOVIE_ID, listMovie[it].id)
                }
                putExtras(bundle)
            }
            startActivity(intent)
        }
        binding.rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvItem.adapter = adapter
        binding.rvItem.adapter?.notifyDataSetChanged()
        binding.rvItem.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(!recyclerView.canScrollVertically(1)) {
                    viewModel.getMovie(genreId, PAGE++)
                }
            }
        })
    }

}