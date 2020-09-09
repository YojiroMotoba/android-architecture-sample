package com.example.android.githubbrowser.binding

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load

@BindingAdapter("items")
fun <T> RecyclerView.dataSetChanged(items: List<T>) {
    adapter?.notifyDataSetChanged()
}

@BindingAdapter("imageUrl")
fun ImageView.imageURI(url: String?) {
    if (TextUtils.isEmpty(url)) {
        return
    }
    load(url)
}