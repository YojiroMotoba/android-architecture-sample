package com.example.android.githubbrowser.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("items")
fun <T> RecyclerView.dataSetChanged(items: List<T>) {
    adapter?.notifyDataSetChanged()
}
