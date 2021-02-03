package com.example.android.githubbrowser.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ActivityDebugBinding
import com.example.android.githubbrowser.ui.adapter.DebugAdapter
import com.example.android.githubbrowser.ui.adapter.DebugSelfAppInformation
import com.example.android.githubbrowser.ui.viewmodel.DebugViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DebugActivity : AppCompatActivity() {

    private val debugViewModel: DebugViewModel by viewModel()
    private lateinit var binding: ActivityDebugBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_debug)
        binding.viewModel = debugViewModel
        binding.lifecycleOwner = this
        binding.activityListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.activityListRecyclerView.adapter = DebugAdapter(
            debugViewModel.debugSelfAppInformationList.value!!
        ).also {
            it.openClick.observe(this, Observer {
                startClickedActivity(it)
            })
        }
        debugViewModel.searchActivities()
    }

    private fun startClickedActivity(debugSelfAppInformation: DebugSelfAppInformation) {
        startActivity(Intent().also {
            it.setClassName(
                debugSelfAppInformation.packageName,
                debugSelfAppInformation.name
            )
        })
    }
}