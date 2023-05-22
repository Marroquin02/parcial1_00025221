package com.camc.tvcanal.ui.tv.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.camc.tvcanal.Repository.TVRepository
import com.camc.tvcanal.TVReviewerApplication
import com.camc.tvcanal.data.model.TVModel

class TVViewModel(private val repository: TVRepository): ViewModel() {
    var name = MutableLiveData("")
    var contenido = MutableLiveData("")
    var status = MutableLiveData("")
    fun getCanal() = repository.getCanal()

    fun addCanal(canal: TVModel) = repository.addCanal(canal)
    fun createMovie(){
        if(!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }
        val canal =TVModel(
            name.value!!,
            contenido.value!!,
        )
        addCanal(canal)
        clearData()

        status.value =  CANAL_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            contenido.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        name.value = ""
        contenido.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun setSelectedCanal(canal: TVModel){
        name.value = canal.nombre
        contenido.value = canal.Contenido
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TVReviewerApplication
                TVViewModel(app.canalRepository)
            }
        }
        const val CANAL_CREATED = "Canal created"
        const val WRONG_INFORMATION = "Wrong information"
        const val  INACTIVE = ""
    }
}