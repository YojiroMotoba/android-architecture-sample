package com.example.android.githubbrowser.ui

import androidx.activity.viewModels
import com.example.android.githubbrowser.InjectorAppCompatActivity
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.ui.viewmodel.DebugViewModel

class DebugActivity : InjectorAppCompatActivity(R.layout.activity_debug) {

    private val debugViewModel: DebugViewModel by viewModels { viewModelFactory }
}