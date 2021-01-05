package com.gilbertohdz.shoestore.ui.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gilbertohdz.shoestore.ui.shoes.models.ShoeDetail
import com.gilbertohdz.shoestore.ui.shoes.models.ShoeObservable

class ShoesViewModel : ViewModel() {

    private val _shoes: MutableLiveData<List<ShoeDetail>> = MutableLiveData()
    val shoes: LiveData<List<ShoeDetail>> = _shoes

    val navigateBack: MutableLiveData<Unit?> = MutableLiveData(null)

    private val shoesList = mutableListOf<ShoeDetail>()

    var shoeObservable = ShoeObservable()

    init {
        shoesList.add(ShoeDetail("Tiro Loco McGraw", "Gilinhos Company", "7", "Dummy from init"))
        _shoes.value = shoesList
    }


    fun addNewShoe() {
        shoesList.add(ShoeDetail(shoeObservable.name, shoeObservable.company, shoeObservable.size, shoeObservable.description))
        _shoes.value = shoesList
        shoeObservable = ShoeObservable()
        navigateBack.value = Unit
    }

    fun cancel() {
        navigateBack.value = Unit
    }
}