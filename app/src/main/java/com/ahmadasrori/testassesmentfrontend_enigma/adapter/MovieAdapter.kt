package com.ahmadasrori.testassesmentfrontend_enigma.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmadasrori.testassesmentfrontend_enigma.R
import com.ahmadasrori.testassesmentfrontend_enigma.databinding.ItemMovieBinding
import com.ahmadasrori.testassesmentfrontend_enigma.model.movie.Movie
import com.ahmadasrori.testassesmentfrontend_enigma.util.Constant
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class MovieAdapter (
    private val activity: Activity,
    private val items: List<Movie>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        ) as ItemMovieBinding
        return ItemVH(viewBinding)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = items[position]
        holder.binding.item = item
        Glide.with(activity)
            .load("${Constant.URL_IMAGE}${item.poster_path}")
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(holder.binding.ivMovie)
        holder.binding.cardItem.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemVH(mainBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(mainBinding.root) {
        val binding = mainBinding
    }

}