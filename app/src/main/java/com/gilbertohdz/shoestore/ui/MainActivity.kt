package com.gilbertohdz.shoestore.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_UNLOCKED
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.gilbertohdz.shoestore.R
import com.gilbertohdz.shoestore.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        toolbar = binding.toolbar
        binding.navView.setNavigationItemSelectedListener(onNavigationViewSetup())
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val toggle = ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()

        appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment, R.id.shoesListFragment), drawerLayout)
        toolbar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.loginFragment,
                R.id.welcomeFragment,
                R.id.instructionFragment -> {
                    drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED)
                    supportActionBar?.hide()
                }
                else -> {
                    drawerLayout.setDrawerLockMode(LOCK_MODE_UNLOCKED)
                    supportActionBar?.show()
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun onNavigationViewSetup() : NavigationView.OnNavigationItemSelectedListener {
        return NavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_log_out -> {
                    this.findNavController(R.id.nav_host_fragment).navigate(R.id.loginFragment)
                }
            }

            closeDrawer()
            return@OnNavigationItemSelectedListener true
        }
    }

    private fun closeDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }
}
