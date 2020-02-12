package com.example.android.githubbrowser.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.api.response.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailSampleViewModel @Inject constructor(
    private val githubApi: GithubApi
) : ViewModel() {

    var repo: MutableLiveData<Repo> = MutableLiveData()

    fun search(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                githubApi.searchRepos(query)
            }
                .onSuccess { searchSuccess(it.items[0]) }
                .onFailure { searchFailure(it) }
        }
    }

    private fun searchSuccess(repo: Repo) {
        viewModelScope.launch {
            this@DetailSampleViewModel.repo.value = repo
        }
    }

    private fun searchFailure(t: Throwable) {
        Log.d("AAA", "searchFailure ${t.message}", t)
    }
}