package com.ahmadasrori.testassesmentfrontend_enigma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmadasrori.testassesmentfrontend_enigma.R
import com.ahmadasrori.testassesmentfrontend_enigma.databinding.ItemReviewBinding
import com.ahmadasrori.testassesmentfrontend_enigma.model.review.Review

class ReviewAdapter (
    private val items: List<Review>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<ReviewAdapter.ItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_review,
            parent,
            false
        ) as ItemReviewBinding
        return ItemVH(viewBinding)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = items[position]
        holder.binding.item = item
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemVH(mainBinding: ItemReviewBinding) :
        RecyclerView.ViewHolder(mainBinding.root) {
        val binding = mainBinding
    }

}