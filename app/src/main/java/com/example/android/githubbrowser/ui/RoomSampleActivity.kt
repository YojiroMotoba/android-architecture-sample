package com.example.android.githubbrowser.ui

import androidx.activity.viewModels
import com.example.android.githubbrowser.InjectorAppCompatActivity
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.ui.viewmodel.RoomSampleViewModel

class RoomSampleActivity : InjectorAppCompatActivity(R.layout.activity_room_sample) {

    private val viewModel: RoomSampleViewModel by viewModels { viewModelFactory }
}
