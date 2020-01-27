package com.example.android.githubbrowser

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.githubbrowser.repository.api.GithubApi
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val githubApi: GithubApi) : ViewModel() {

    fun searchRepos() {
        viewModelScope.launch {
            try {
                Log.d("AAA", "start githubApi.searchRepos")
                val res = githubApi.searchRepos("test")
                Log.d("AAA", res.items[0].id.toString())
            } catch (e: Exception) {
                Log.e("AAA", e.message, e)
            }
        }
    }
}