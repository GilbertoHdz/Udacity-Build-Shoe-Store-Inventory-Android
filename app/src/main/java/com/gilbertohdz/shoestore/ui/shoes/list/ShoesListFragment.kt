package com.gilbertohdz.shoestore.ui.shoes.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gilbertohdz.shoestore.R
import com.gilbertohdz.shoestore.databinding.FragmentShoesListBinding
import com.gilbertohdz.shoestore.ui.shoes.ShoesViewModel
import com.gilbertohdz.shoestore.ui.shoes.list.view.ShoesListAdapter
import com.gilbertohdz.shoestore.ui.shoes.models.ShoeDetail
import java.lang.StringBuilder

class ShoesListFragment : Fragment() {

    private lateinit var binding: FragmentShoesListBinding

    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            it?.forEach(this::addingItemToLayout)
        })

        binding.shoesListGoToDetailAction.setOnClickListener {
            findNavController().navigate(ShoesListFragmentDirections.actionToShoesDetailFragment())
        }
    }

    private fun addingItemToLayout(item: ShoeDetail) {
        val textView = TextView(requireContext())

        val sb = StringBuilder()

        sb.append(requireContext().getString(R.string.item_shoe_name, item.name)).append("\n")
        sb.append(requireContext().getString(R.string.item_shoe_company, item.company)).append("\n")
        sb.append(requireContext().getString(R.string.item_shoe_size, item.size)).append("\n")
        sb.append(requireContext().getString(R.string.item_shoe_description, item.description)).append("\n")
        sb.append("----------------------------------------")
        textView.text = sb.toString()

        val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )

        textView.layoutParams = params

        binding.shoesListLinearLayoutContainer.addView(textView)
    }
}