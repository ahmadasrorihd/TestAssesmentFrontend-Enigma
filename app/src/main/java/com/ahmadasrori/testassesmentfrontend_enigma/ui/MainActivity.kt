package com.ahmadasrori.testassesmentfrontend_enigma.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadasrori.testassesmentfrontend_enigma.adapter.GenreAdapter
import com.ahmadasrori.testassesmentfrontend_enigma.databinding.ActivityMainBinding
import com.ahmadasrori.testassesmentfrontend_enigma.model.genre.Genre
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant.BUNDLE.GENRE_ID
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant.BUNDLE.GENRE_NAME
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()
    private val listGenre = ArrayList<Genre>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observeGenre()
        viewModel.getGenre()
    }

    private fun observeGenre(){
        viewModel.genre.observe(this, {
            it.let {
                listGenre.addAll(it)
                initList()
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initList() {
        val adapter = GenreAdapter(listGenre) {
            val intent = Intent(this, MovieActivity::class.java).apply {
                val bundle = Bundle().apply {
                    putInt(GENRE_ID, listGenre[it].id)
                    putString(GENRE_NAME, listGenre[it].name)
                }
                putExtras(bundle)
            }
            startActivity(intent)
        }
        binding.rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvItem.adapter = adapter
        binding.rvItem.adapter?.notifyDataSetChanged()
    }

}