package com.example.android.githubbrowser.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.githubbrowser.InjectorAppCompatActivity
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ActivityDebugBinding
import com.example.android.githubbrowser.ui.adapter.DebugAdapter
import com.example.android.githubbrowser.ui.adapter.DebugSelfAppInformation
import com.example.android.githubbrowser.ui.viewmodel.DebugViewModel
import kotlinx.android.synthetic.main.activity_debug.*


class DebugActivity : InjectorAppCompatActivity(R.layout.activity_debug) {

    private val debugViewModel: DebugViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityDebugBinding>(this, R.layout.activity_debug)
            .let {
                it.viewModel = debugViewModel
                it.lifecycleOwner = this
            }

        activity_list_RecyclerView.layoutManager = LinearLayoutManager(this)
        activity_list_RecyclerView.adapter = DebugAdapter(
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