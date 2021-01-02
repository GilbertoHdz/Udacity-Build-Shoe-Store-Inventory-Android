package com.gilbertohdz.shoestore.ui.shoes.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gilbertohdz.shoestore.databinding.FragmentShoesDetailBinding
import com.gilbertohdz.shoestore.ui.shoes.ShoesViewModel
import com.gilbertohdz.shoestore.ui.shoes.models.ShoeDetail

class ShoesDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoesDetailBinding
    private lateinit var viewModel: ShoesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)

        binding = FragmentShoesDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shoesDetailSaveAction.setOnClickListener {
            addNewItem()
        }
        binding.shoesDetailCancelAction.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun addNewItem() {
        binding.let {
            val newItem = ShoeDetail(
                    it.shoesDetailNameEdit.text.toString(),
                    it.shoesDetailCompanyEdit.text.toString(),
                    it.shoesDetailSizeEdit.text.toString(),
                    it.shoesDetailDescriptionEdit.text.toString()
            )

            viewModel.addNewShoe(newItem)
            findNavController().popBackStack()
        }
    }
}