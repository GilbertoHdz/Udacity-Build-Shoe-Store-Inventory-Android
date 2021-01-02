package com.gilbertohdz.shoestore.ui.shoes.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.gilbertohdz.shoestore.R
import com.gilbertohdz.shoestore.databinding.FragmentShoesListBinding
import com.gilbertohdz.shoestore.ui.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shoesListGoToDetailAction.setOnClickListener {
            findNavController().navigate(ShoesListFragmentDirections.actionToShoesDetailFragment())
        }
    }
}