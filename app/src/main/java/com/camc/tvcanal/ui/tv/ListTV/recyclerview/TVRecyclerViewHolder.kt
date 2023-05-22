package com.camc.tvcanal.ui.tv.ListTV.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.camc.tvcanal.data.model.TVModel
import com.camc.tvcanal.databinding.TvitemBinding

class TVRecyclerViewHolder(private val binding: TvitemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(tv : TVModel, clickListener: (TVModel) -> Unit){
        binding.nameTextView.text = tv.nombre
        binding.contenidoTextView.text = tv.Contenido

        binding.canalItemCardView.setOnClickListener{
            clickListener(tv)
        }
    }
}