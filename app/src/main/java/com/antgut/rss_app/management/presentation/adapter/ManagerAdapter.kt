package com.antgut.rss_app.management.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antgut.rss_app.R
import com.antgut.rss_app.management.domain.ManagementModel

class ManagerAdapter : RecyclerView.Adapter<ManagerViewHolder>(){

    var setOfData = mutableListOf<ManagementModel>()

    fun setDataItems(rssvalue: List<ManagementModel>) {
        setOfData.clear()
        setOfData.addAll(rssvalue)
        notifyDataSetChanged()
    }
    private var clickItem: ((String) -> Unit)? =null

    fun setOnClick(clickItem :(String) -> Unit){
        this.clickItem = clickItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_user_item, parent, false)
        return ManagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ManagerViewHolder, position: Int) {
        holder.bind(setOfData[position], clickItem)
    }

    override fun getItemCount(): Int {
        return setOfData.size
    }


}
