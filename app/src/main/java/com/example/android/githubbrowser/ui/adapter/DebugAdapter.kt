package com.example.android.githubbrowser.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ItemDebugRecyclerViewBinding


class DebugAdapter(
    private var dataList: List<DebugSelfAppInformation>,
    private var openClick: (DebugSelfAppInformation) -> Unit
) :
    RecyclerView.Adapter<DebugAdapter.BindingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BindingHolder(parent)

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        holder.bind(dataList[position], openClick)
    }

    override fun getItemCount() = dataList.size

    class BindingHolder(
        private val parent: ViewGroup,
        private val binding: ItemDebugRecyclerViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_debug_recycler_view,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: DebugSelfAppInformation,
            openClick: (DebugSelfAppInformation) -> Unit
        ) {
            binding.debugSelfAppInformation = item
            binding.openButton.setOnClickListener {
                openClick(item)
            }
            binding.executePendingBindings()
        }
    }
}

@BindingAdapter("items")
fun <T> RecyclerView.bindItems(items: List<T>) {
    adapter?.notifyDataSetChanged()
}
