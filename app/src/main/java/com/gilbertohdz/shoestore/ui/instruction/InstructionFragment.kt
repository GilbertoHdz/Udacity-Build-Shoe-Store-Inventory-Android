package com.gilbertohdz.shoestore.ui.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gilbertohdz.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.instructionToInstructionAction.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionToShoesListFragment())
        }
    }
}