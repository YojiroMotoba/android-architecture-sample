package com.example.android.githubbrowser.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.githubbrowser.InjectorAppCompatActivity
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ActivityDebugBinding
import com.example.android.githubbrowser.ui.adapter.DebugAdapter
import com.example.android.githubbrowser.ui.viewmodel.DebugViewModel
import kotlinx.android.synthetic.main.activity_debug.*


class DebugActivity : InjectorAppCompatActivity(R.layout.activity_debug) {

    private val debugViewModel: DebugViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDebugBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_debug)
        binding.viewModel = debugViewModel
        binding.lifecycleOwner = this
        activity_list_RecyclerView.layoutManager = LinearLayoutManager(this)
        activity_list_RecyclerView.adapter =
            DebugAdapter(debugViewModel.debugSelfAppInformationList.value!!)
        debugViewModel.searchActivities()
        add_data_button.setOnClickListener { debugViewModel.searchActivities() }
    }
}