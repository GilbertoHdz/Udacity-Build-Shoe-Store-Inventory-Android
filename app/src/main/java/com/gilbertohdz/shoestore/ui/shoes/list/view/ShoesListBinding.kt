package com.gilbertohdz.shoestore.ui.shoes.list.view

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gilbertohdz.shoestore.ui.shoes.models.ShoeDetail

object ShoesListBinding {

    @BindingAdapter("app:shoesItems")
    @JvmStatic fun setShoesItems(
            recyclerView: RecyclerView,
            result: List<ShoeDetail>?
    ) {
        if (result == null) {
            return
        }
        with(recyclerView.adapter as ShoesListAdapter) {
            updateData(result)
        }
    }
}