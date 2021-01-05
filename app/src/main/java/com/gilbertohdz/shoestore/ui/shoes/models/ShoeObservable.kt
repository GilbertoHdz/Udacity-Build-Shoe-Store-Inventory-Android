package com.gilbertohdz.shoestore.ui.shoes.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.gilbertohdz.shoestore.BR

class ShoeObservable : BaseObservable() {

    private var _name = ""
    private var _company = ""
    private var _size = ""
    private var _description = ""

    @get:Bindable
    var name: String = _name
        set(value) {
            // Avoids infinite loops.
            if (field != value) {
                // shoeDetail.name = value

                // Notify observers of a new value.
                notifyPropertyChanged(BR.name)
            }
            field = value
        }

    @get:Bindable
    var company: String = _company
        set(value) {
            // Avoids infinite loops.
            if (field != value) {
                // shoeDetail.company = value

                // Notify observers of a new value.
                notifyPropertyChanged(BR.company)
            }
            field = value
        }

    @get:Bindable
    var size: String = _size
        set(value) {
            // Avoids infinite loops.
            if (field != value) {
                // shoeDetail.company = value

                // Notify observers of a new value.
                notifyPropertyChanged(BR.size)
            }
            field = value
        }


    @get:Bindable
    var description: String = _description
        set(value) {
            // Avoids infinite loops.
            if (field != value) {
                // shoeDetail.company = value

                // Notify observers of a new value.
                notifyPropertyChanged(BR.description)
            }
            field = value
        }
}