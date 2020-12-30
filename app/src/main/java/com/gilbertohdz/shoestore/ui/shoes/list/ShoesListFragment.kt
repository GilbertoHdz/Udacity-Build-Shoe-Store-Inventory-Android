package com.gilbertohdz.shoestore.ui.shoes.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gilbertohdz.shoestore.databinding.FragmentShoesListBinding

class ShoesListFragment : Fragment() {

    private lateinit var binding: FragmentShoesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoesListBinding.inflate(inflater, container, false)
        return binding.root
    }
}