package com.gilbertohdz.shoestore.ui.login

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.gilbertohdz.shoestore.R
import com.gilbertohdz.shoestore.databinding.FragmentLoginBinding
import com.gilbertohdz.shoestore.ui.MainActivity

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loginLogInAction.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionToWelcomeFragment())
            }

            loginExistAccountAction.setOnClickListener {
                findNavController().apply {
                    val navOptions = NavOptions.Builder()
                            .setPopUpTo(graph.startDestination, true)
                            .build()
                    navigate(LoginFragmentDirections.actionToShoesListFragment(), navOptions)
                }
            }
        }
    }
}