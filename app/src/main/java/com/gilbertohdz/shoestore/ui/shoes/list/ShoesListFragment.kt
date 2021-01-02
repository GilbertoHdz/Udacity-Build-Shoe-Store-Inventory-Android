package com.gilbertohdz.shoestore.ui.shoes.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gilbertohdz.shoestore.databinding.FragmentShoesListBinding
import com.gilbertohdz.shoestore.ui.shoes.ShoesViewModel
import com.gilbertohdz.shoestore.ui.shoes.list.view.ShoesListAdapter

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
        // val shoesVieModel: ShoesViewModel by viewModels()
        val viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)

        binding = FragmentShoesListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.shoesListRecyclerView.adapter = ShoesListAdapter(viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shoesListGoToDetailAction.setOnClickListener {
            findNavController().navigate(ShoesListFragmentDirections.actionToShoesDetailFragment())
        }
    }
}