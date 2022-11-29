package com.antgut.rss_app.feed.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.antgut.rss_app.databinding.FragmentRssFeedBinding

class RssFeedFragment : Fragment() {

    private var binding: FragmentRssFeedBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssFeedBinding.inflate(inflater)
        return binding?.root
    }
}