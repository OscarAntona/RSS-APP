package com.antgut.rss_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.antgut.rss_app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupNavigation()
    }

    fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    fun setupNavigation() {
        findViewById<BottomNavigationView>(R.id.bottom_menu).setOnItemSelectedListener {
            when (it.itemId) {
                R.id.to_profile_item -> navigateToProfile()
                R.id.to_manager_item -> navigateToManager()
                R.id.to_feed_item -> navigateToFeed()
            }
            true
        }

    }

    fun navigateToProfile() {
        findNavController(R.id.fragment_container_view).navigate(NavGraphDirections.actionToProfile())
    }

    fun navigateToManager() {
        findNavController(R.id.fragment_container_view).navigate(NavGraphDirections.actionToManager())
    }

    fun navigateToFeed() {
        findNavController(R.id.fragment_container_view).navigate(NavGraphDirections.actionToFeed())
    }


}

