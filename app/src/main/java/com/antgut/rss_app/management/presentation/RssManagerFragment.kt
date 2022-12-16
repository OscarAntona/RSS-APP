package com.antgut.rss_app.management.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.antgut.rss_app.R
import com.antgut.rss_app.databinding.FragmentRssManagerBinding

class RssManagerFragment : Fragment() {

    var binding: FragmentRssManagerBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssManagerBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    private fun setupView() {
        binding?.rssManagerToolbar?.apply {
            title = getString(R.string.manager_fragment_title)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_add_rss -> showBottomSheet()
                }
                true
            }
        }
    }

    private fun showBottomSheet() {
        findNavController().navigate(ManagerFragmentDirections.actionToBottomSheet())
    }
}