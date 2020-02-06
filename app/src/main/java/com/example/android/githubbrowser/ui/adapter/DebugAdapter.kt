package com.example.android.githubbrowser.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.githubbrowser.databinding.ItemDebugRecyclerViewBinding


class DebugAdapter(private var dataList: List<DebugSelfAppInformation>) :
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
            debugSelfAppInformation = dataList[position]
        }
    }

    override fun getItemCount() = dataList.size

    fun setData(items: List<DebugSelfAppInformation>) {
        dataList = items
        notifyDataSetChanged()
    }

    class BindingHolder(var binding: ItemDebugRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}
