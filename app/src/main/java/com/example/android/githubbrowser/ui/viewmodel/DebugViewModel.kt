package com.example.android.githubbrowser.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DebugViewModel @Inject constructor(
    private val context: Context
) : ViewModel() {

    fun searchActivities() {
        val packageManager = context.packageManager
    }
}