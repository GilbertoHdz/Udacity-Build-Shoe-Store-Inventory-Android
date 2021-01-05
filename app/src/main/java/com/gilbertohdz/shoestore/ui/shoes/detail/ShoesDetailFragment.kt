package com.gilbertohdz.shoestore.ui.shoes.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.gilbertohdz.shoestore.R
import com.gilbertohdz.shoestore.databinding.FragmentShoesDetailBinding
import com.gilbertohdz.shoestore.ui.shoes.ShoesViewModel

class ShoesDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoesDetailBinding
    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_detail, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigateBack.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().popBackStack()
                viewModel.navigateBack.value = null
            }
        })
    }
}