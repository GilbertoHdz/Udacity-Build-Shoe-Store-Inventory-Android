package com.gilbertohdz.shoestore.ui.shoes.list.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gilbertohdz.shoestore.R
import com.gilbertohdz.shoestore.ui.shoes.ShoesViewModel
import com.gilbertohdz.shoestore.ui.shoes.models.ShoeDetail

class ShoesListAdapter(
        private val shoesViewModel: ShoesViewModel
) : RecyclerView.Adapter<ShoesListViewHolder>() {

    private val shoes = mutableListOf<ShoeDetail>()

    fun ViewGroup.inflate(
            layoutResId: Int
    ): View = LayoutInflater.from(this.context).inflate(layoutResId, this, false)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesListViewHolder {
        return ShoesListViewHolder(parent.inflate(R.layout.item_shoes))
    }

    override fun onBindViewHolder(holder: ShoesListViewHolder, position: Int) {
        holder.bindTo(shoes[position])
    }

    override fun getItemCount(): Int = shoes.size

    fun updateData(items: List<ShoeDetail>) {
        shoes.clear()
        shoes.addAll(items)
        notifyDataSetChanged()
    }
}