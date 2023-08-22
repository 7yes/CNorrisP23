package com.example.cnorrisp.data.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cnorrisp.databinding.ItemJokesBinding

class ChuckVH(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemJokesBinding.bind(view)
    fun bind(item: String) {
        binding.tvQueryItem.text = item
    }
}
