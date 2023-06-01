package com.capstone.composeapp.presentations.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.composeapp.domain.model.Plant

class SharedViewModel : ViewModel() {
    private val _plant : MutableLiveData<Plant> = MutableLiveData<Plant>()
    val plantLive : LiveData<Plant> = _plant

    fun setPlantDetail(plant: Plant){
        _plant.value = plant
    }
}