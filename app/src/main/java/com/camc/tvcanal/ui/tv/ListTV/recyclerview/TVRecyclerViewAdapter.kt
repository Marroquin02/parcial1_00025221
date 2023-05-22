package com.camc.tvcanal.ui.tv.ListTV.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.camc.tvcanal.data.model.TVModel
import com.camc.tvcanal.databinding.TvitemBinding

class TVRecyclerViewAdapter (
    private val clickListener: (TVModel) -> Unit
) : RecyclerView.Adapter<TVRecyclerViewHolder>() {
    private val movies = ArrayList<TVModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVRecyclerViewHolder {
        val binding = TvitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: TVRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    fun setData(movieslist: List<TVModel>){
        movies.clear()
        movies.addAll(movieslist)
    }
}
