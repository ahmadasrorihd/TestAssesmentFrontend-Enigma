package com.ahmadasrori.testassesmentfrontend_enigma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmadasrori.testassesmentfrontend_enigma.R
import com.ahmadasrori.testassesmentfrontend_enigma.databinding.ItemGenreBinding
import com.ahmadasrori.testassesmentfrontend_enigma.model.genre.Genre

class GenreAdapter (
    private val items: List<Genre>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<GenreAdapter.ItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_genre,
            parent,
            false
        ) as ItemGenreBinding
        return ItemVH(viewBinding)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = items[position]
        holder.binding.item = item
        holder.binding.cardItem.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemVH(mainBinding: ItemGenreBinding) :
        RecyclerView.ViewHolder(mainBinding.root) {
        val binding = mainBinding
    }

}