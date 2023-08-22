package com.example.cnorrisp.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cnorrisp.R

class ChuckAdapter(private val jokes:List<String>) : RecyclerView.Adapter<ChuckVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChuckVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ChuckVH(layoutInflater.inflate(R.layout.item_jokes,parent,false))
    }

    override fun getItemCount(): Int = jokes.size

    override fun onBindViewHolder(holder: ChuckVH, position: Int) {
        val item = jokes[position]
        holder.bind(item)
    }
}
