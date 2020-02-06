package com.example.android.githubbrowser.ui.adapter

import android.content.pm.ActivityInfo
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.githubbrowser.databinding.ItemDebugRecyclerViewBinding


class DebugAdapter(private var dataList: List<ActivityInfo>) :
    RecyclerView.Adapter<DebugAdapter.BindingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BindingHolder(
            ItemDebugRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        holder.binding.apply {
            activityInfo = dataList[position]
        }
    }

    override fun getItemCount() = dataList.size

    fun setData(items: List<ActivityInfo>) {
        dataList = items
        notifyDataSetChanged()
    }

    class BindingHolder(var binding: ItemDebugRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}