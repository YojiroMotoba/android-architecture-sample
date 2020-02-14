package com.example.android.githubbrowser.binding

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("items")
fun <T> RecyclerView.dataSetChanged(items: List<T>) {
    adapter?.notifyDataSetChanged()
}

@BindingAdapter("imageUrl")
fun ImageView.imageURI(url: String?) {
    if (TextUtils.isEmpty(url)) {
        return
    }
    Glide.with(this)
        .load(url)
        .into(this)
}