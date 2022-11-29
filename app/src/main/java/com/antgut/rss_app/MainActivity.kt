package com.antgut.rss_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.antgut.rss_app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.color.DynamicColors

class MainActivity : AppCompatActivity(){

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupNavigation()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun setupNavigation() {
        findViewById<BottomNavigationView>(R.id.bottom_menu).setOnItemSelectedListener {
            when (it.itemId) {
                R.id.to_profile_item -> navigateToProfile()
                R.id.to_manager_item -> navigateToManager()
                R.id.to_feed_item -> navigateToFeed()
            }
            true
        }

    }

    private fun navigateToProfile() {
        findNavController(R.id.fragment_container_view).navigate(NavGraphDirections.actionToProfile())
    }

    private fun navigateToManager() {
        findNavController(R.id.fragment_container_view).navigate(NavGraphDirections.actionToManager())
    }

    private fun navigateToFeed() {
        findNavController(R.id.fragment_container_view).navigate(NavGraphDirections.actionToFeed())
    }

}