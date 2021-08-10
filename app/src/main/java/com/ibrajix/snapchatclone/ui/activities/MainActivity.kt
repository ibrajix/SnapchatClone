package com.ibrajix.snapchatclone.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.ibrajix.snapchatclone.R
import com.ibrajix.snapchatclone.databinding.ActivityMainBinding
import com.ibrajix.snapchatclone.utis.Utility.transparentStatusBar
import com.ibrajix.snapchatclone.utis.Utility.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_SnapchatClone)

        super.onCreate(savedInstanceState)

        transparentStatusBar()

        setContentView(binding.root)

        initViews()

    }

    private fun initViews(){

        setUpBottomNavigation()

    }

    private fun setUpBottomNavigation(){

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHost.navController

        binding.bottomNavigation.setupWithNavController(navController)

        binding.bottomNavigation.setOnItemReselectedListener {
            //do something when selected twice
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(
                item,
                Navigation.findNavController(this, R.id.nav_host_fragment)
            )
        }

        binding.bottomNavigation.itemIconTintList = null

        //if we are viewing stories, hide the bottom navigation
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.viewStoriesFragment) {

                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }


    }

}