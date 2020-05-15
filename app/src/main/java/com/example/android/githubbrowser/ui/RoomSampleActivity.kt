package com.example.android.githubbrowser.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ActivityRoomSampleBinding
import com.example.android.githubbrowser.ui.viewmodel.RoomSampleViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomSampleActivity : AppCompatActivity() {

    private val viewModel: RoomSampleViewModel by viewModel()

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
