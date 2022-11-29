package com.antgut.rss_app.management.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.antgut.rss_app.databinding.FragmentRssManagerBinding

class RssManagerFragment : Fragment() {

    var binding: FragmentRssManagerBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssManagerBinding.inflate(inflater)
        return binding?.root
    }


}