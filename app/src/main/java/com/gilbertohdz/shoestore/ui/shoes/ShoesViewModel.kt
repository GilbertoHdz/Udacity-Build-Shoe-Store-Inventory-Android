package com.gilbertohdz.shoestore.ui.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gilbertohdz.shoestore.ui.shoes.models.ShoeDetail

class ShoesViewModel : ViewModel() {

    private val _shoes: MutableLiveData<List<ShoeDetail>> = MutableLiveData()
    val shoes: LiveData<List<ShoeDetail>> = _shoes

    private val shoesList = mutableListOf<ShoeDetail>()

    init {
        shoesList.add(ShoeDetail("Tiro Loco McGraw", "Gilinhos Company", "7", "Dummy from init"))
        _shoes.value = shoesList
    }


    fun addNewShoe(newItem: ShoeDetail) {
        shoesList.add(newItem)
        _shoes.value = shoesList
    }
}