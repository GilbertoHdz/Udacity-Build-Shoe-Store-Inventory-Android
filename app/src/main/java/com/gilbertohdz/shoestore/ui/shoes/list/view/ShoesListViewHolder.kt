package com.gilbertohdz.shoestore.ui.shoes.list.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gilbertohdz.shoestore.databinding.ItemShoesBinding
import com.gilbertohdz.shoestore.ui.shoes.models.ShoeDetail

class ShoesListViewHolder(
        itemView: View
) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemShoesBinding.bind(itemView)

    fun bindTo(shoeDetail: ShoeDetail) {
        binding.shoeDet = shoeDetail
    }
}