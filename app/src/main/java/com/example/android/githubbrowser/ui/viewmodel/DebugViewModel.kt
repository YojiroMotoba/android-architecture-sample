package com.example.android.githubbrowser.ui.viewmodel

import android.content.pm.ActivityInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.githubbrowser.GithubBrowserApp
import com.example.android.githubbrowser.ui.adapter.DebugSelfAppInformation

class DebugViewModel(
    private val application: GithubBrowserApp
) : ViewModel() {

    var debugSelfAppInformationList =
        MutableLiveData<MutableList<DebugSelfAppInformation>>(mutableListOf())

    val clickAddData = View.OnClickListener {
        searchActivities()
    }

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