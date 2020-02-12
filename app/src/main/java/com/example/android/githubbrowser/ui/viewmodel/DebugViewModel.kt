package com.example.android.githubbrowser.ui.viewmodel

import android.content.pm.ActivityInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.githubbrowser.GithubBrowserApp
import com.example.android.githubbrowser.ui.adapter.DebugSelfAppInformation
import javax.inject.Inject

class DebugViewModel @Inject constructor(
    private val application: GithubBrowserApp
) : ViewModel() {

    var debugSelfAppInformationList =
        MutableLiveData<MutableList<DebugSelfAppInformation>>(mutableListOf())

    fun searchActivities() {
        packageInfo(application.packageManager).activities.forEach {
            debugSelfAppInformationList.value!!.add(
                convertActivityInfoToDebugInfo(it)
            )
        }
        debugSelfAppInformationList.postValue(debugSelfAppInformationList.value)
    }

    private fun packageInfo(packageManager: PackageManager): PackageInfo =
        packageManager.getPackageInfo(application.packageName, PackageManager.GET_ACTIVITIES)

    private fun convertActivityInfoToDebugInfo(activityInfo: ActivityInfo): DebugSelfAppInformation =
        DebugSelfAppInformation(
            activityInfo.packageName,
            activityInfo.name.split(".").last(),
            activityInfo.name
        )
}