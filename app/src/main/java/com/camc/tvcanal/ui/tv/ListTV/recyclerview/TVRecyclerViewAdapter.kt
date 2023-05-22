package com.camc.tvcanal.ui.tv.ListTV.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.camc.tvcanal.data.model.TVModel
import com.camc.tvcanal.databinding.TvitemBinding

class TVRecyclerViewAdapter (
    private val clickListener: (TVModel) -> Unit
) : RecyclerView.Adapter<TVRecyclerViewHolder>() {
    private val canals = ArrayList<TVModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVRecyclerViewHolder {
        val binding = TvitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return canals.size
    }

    override fun onBindViewHolder(holder: TVRecyclerViewHolder, position: Int) {
        val canal = canals[position]
        holder.bind(canal, clickListener)
    }

    
    fun setData(canallist: List<TVModel>){
        canals.clear()
        canals.addAll(canallist)
    }
}
