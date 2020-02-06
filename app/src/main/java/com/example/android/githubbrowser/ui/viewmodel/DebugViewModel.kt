package com.example.android.githubbrowser.ui.viewmodel

import android.content.pm.PackageManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.githubbrowser.GithubBrowserApp
import com.example.android.githubbrowser.ui.adapter.DebugSelfAppInformation
import javax.inject.Inject

class DebugViewModel @Inject constructor(
    private val application: GithubBrowserApp
) : ViewModel() {

    var debugSelfAppInformationList = MutableLiveData<MutableList<DebugSelfAppInformation>>()
    private var _debugSelfAppInformationList: MutableList<DebugSelfAppInformation> = mutableListOf()

    init {
        debugSelfAppInformationList.value = mutableListOf()
    }

    fun searchActivities() {
        val packageManager = application.packageManager
        val packageInfo =
            packageManager.getPackageInfo(application.packageName, PackageManager.GET_ACTIVITIES)
        packageInfo.activities.forEach { activityInfo ->
            debugSelfAppInformationList.value!!.add(
                DebugSelfAppInformation(
                    activityInfo.packageName,
                    activityInfo.name.split(".").last()
                )
            )
            debugSelfAppInformationList.postValue(debugSelfAppInformationList.value)
        }
    }
}