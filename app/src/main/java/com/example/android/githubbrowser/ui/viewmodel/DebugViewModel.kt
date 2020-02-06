package com.example.android.githubbrowser.ui.viewmodel

import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.githubbrowser.GithubBrowserApp
import javax.inject.Inject

class DebugViewModel @Inject constructor(
    private val application: GithubBrowserApp
) : ViewModel() {

    var activityInfoList = MutableLiveData<MutableList<ActivityInfo>>()

    init {
        activityInfoList.value = mutableListOf()
    }

    fun searchActivities() {
        val packageManager = application.packageManager
        val packageInfo =
            packageManager.getPackageInfo(application.packageName, PackageManager.GET_ACTIVITIES)
        activityInfoList.value!!.addAll(packageInfo.activities)
    }
}