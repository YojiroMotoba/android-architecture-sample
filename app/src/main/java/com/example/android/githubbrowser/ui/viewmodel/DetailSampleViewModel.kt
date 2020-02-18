package com.example.android.githubbrowser.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.githubbrowser.interactor.GithubInteractor
import com.example.android.githubbrowser.repository.api.response.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailSampleViewModel @Inject constructor(
    private val githubInteractor: GithubInteractor
) : ViewModel() {

    var repo: MutableLiveData<Repo> = MutableLiveData()

    fun search(query: String) {
        viewModelScope.launch {
            runCatching {
                withContext(Dispatchers.IO) {
                    githubInteractor.searchRepos(query)
                }
            }
                .onSuccess { searchSuccess(it[0]) }
                .onFailure { searchFailure(it) }
        }
    }

    fun exception() {
        viewModelScope.launch {
            githubInteractor.exceptionSample()
        }
    }

    private fun searchSuccess(repo: Repo) {
        this.repo.value = repo
    }

    private fun searchFailure(t: Throwable) {
        Log.d("AAA", "searchFailure ${t.message}", t)
    }
}
