package com.camc.tvcanal.Repository

import com.camc.tvcanal.data.model.TVModel

class TVRepository(private val canal: MutableList<TVModel>) {
    fun getCanal() = canal
    fun addCanal(tv: TVModel) = canal.add(tv)
}