package com.ahmadasrori.testassesmentfrontend_enigma.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmadasrori.testassesmentfrontend_enigma.R
import com.ahmadasrori.testassesmentfrontend_enigma.databinding.ItemTrailerBinding
import com.ahmadasrori.testassesmentfrontend_enigma.model.trailer.TrailerVideo
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


class TrailerAdapter (
    private val activity: Activity,
    private val items: List<TrailerVideo>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<TrailerAdapter.ItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_trailer,
            parent,
            false
        ) as ItemTrailerBinding
        return ItemVH(viewBinding)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = items[position]
        holder.binding.item = item
        holder.binding.cardItem.setOnClickListener {
            onItemClick(position)
        }
        Glide.with(activity)
            .load("https://img.youtube.com/vi/"+item.key+"/0.jpg")
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(holder.binding.ivTrailer)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemVH(mainBinding: ItemTrailerBinding) :
        RecyclerView.ViewHolder(mainBinding.root) {
        val binding = mainBinding
    }

}