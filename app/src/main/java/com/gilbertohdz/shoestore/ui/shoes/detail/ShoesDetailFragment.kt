package com.gilbertohdz.shoestore.ui.shoes.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gilbertohdz.shoestore.databinding.FragmentShoesDetailBinding

class ShoesDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoesDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoesDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
}