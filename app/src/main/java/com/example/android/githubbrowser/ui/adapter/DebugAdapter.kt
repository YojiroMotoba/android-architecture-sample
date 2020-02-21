package com.example.android.githubbrowser.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ItemDebugRecyclerViewBinding


class DebugAdapter(
    private var dataList: List<DebugSelfAppInformation>
) :
    RecyclerView.Adapter<DebugAdapter.BindingHolder>() {

    val openClick = MutableLiveData<DebugSelfAppInformation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BindingHolder(parent)

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    inner class BindingHolder(
        private val parent: ViewGroup,
        private val binding: ItemDebugRecyclerViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_debug_recycler_view,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: DebugSelfAppInformation
        ) {
            binding.let {
                it.debugSelfAppInformation = item
                it.onOpenClick = View.OnClickListener { this@DebugAdapter.openClick.value = item }
                it.executePendingBindings()
            }
        }
    }
}
