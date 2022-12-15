package com.antgut.rss_app.management.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.antgut.rss_app.databinding.FragmentUserItemBinding
import com.antgut.rss_app.management.domain.ManagementModel

class ManagerViewHolder (val view: View): RecyclerView.ViewHolder(view){
    fun bind(rssvalue: ManagementModel, clickItem: ((String) -> Unit)?){
        val binding = FragmentUserItemBinding.bind(view)
        binding.nombreRss.text = rssvalue.name
        binding.urlRss.text = rssvalue.url
        binding.deleteItemIcon.setOnClickListener {
            clickItem?.invoke(rssvalue.url)
        }
    }
}