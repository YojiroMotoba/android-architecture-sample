package com.example.android.githubbrowser.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.android.githubbrowser.InjectorAppCompatActivity
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ActivityRoomSampleBinding
import com.example.android.githubbrowser.ui.viewmodel.RoomSampleViewModel

class RoomSampleActivity : InjectorAppCompatActivity(R.layout.activity_room_sample) {

    private val viewModel: RoomSampleViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityRoomSampleBinding>(
            this,
            R.layout.activity_room_sample
        ).let {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }
    }
}
