package com.example.android.githubbrowser

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.api.response.RepoSearchResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val githubApi: GithubApi) : ViewModel() {

    fun searchRepos() {
        viewModelScope.launch {
            runCatching {
                githubApi.searchRepos("test")
            }
                .onSuccess { searchReposSuccess(it) }
                .onFailure { searchReposFailure(it) }
                .also { searchReposAlso(it) }
        }
    }

    private fun searchReposSuccess(response: RepoSearchResponse) {
        Log.d("AAA", response.items[0].id.toString())
    }

    private fun searchReposFailure(t: Throwable) {
        Log.e("AAA", t.message, t)
    }

    private fun searchReposAlso(result: Result<RepoSearchResponse>) {
        Log.e("AAA", result.isFailure.toString())
    }
}
