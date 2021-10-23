package com.ahmadasrori.testassesmentfrontend_enigma.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ahmadasrori.testassesmentfrontend_enigma.databinding.ActivityVideoBinding
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant
import org.koin.android.viewmodel.ext.android.viewModel

class VideoActivity : AppCompatActivity() {
    private val binding: ActivityVideoBinding by lazy {
        ActivityVideoBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()
    private var videoKey: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val args = intent.extras
        videoKey = args?.getString(Constant.BUNDLE.VIDEO_KEY)
        binding.videoPlayer.setVideoPath(Constant.URL_YOUTUBE+videoKey)
    }
}