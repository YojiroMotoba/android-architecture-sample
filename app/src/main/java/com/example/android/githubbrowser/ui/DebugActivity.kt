package com.example.android.githubbrowser.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.githubbrowser.InjectorAppCompatActivity
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.ui.adapter.DebugAdapter
import com.example.android.githubbrowser.ui.viewmodel.DebugViewModel
import kotlinx.android.synthetic.main.activity_debug.*

class DebugActivity : InjectorAppCompatActivity(R.layout.activity_debug) {

    private val debugViewModel: DebugViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity_list_RecyclerView.layoutManager = LinearLayoutManager(this)
        activity_list_RecyclerView.adapter = DebugAdapter(debugViewModel.activityInfoList.value!!)
        debugViewModel.activityInfoList.observe(this, Observer {
            val adapter = activity_list_RecyclerView.adapter as DebugAdapter?
            adapter?.setData(debugViewModel.activityInfoList.value!!)
        })
        debugViewModel.searchActivities()
    }
}