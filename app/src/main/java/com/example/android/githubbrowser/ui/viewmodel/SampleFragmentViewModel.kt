package com.example.android.githubbrowser.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.githubbrowser.interactor.GithubInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SampleFragmentViewModel @Inject constructor(
    private val githubInteractor: GithubInteractor
) : ViewModel() {

    fun search(query: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    githubInteractor.searchRepos(query)
                }
            }
                .onSuccess { searchSuccess() }
                .onFailure { searchFailure() }
        }
    }

    private fun searchSuccess() {
        Log.d("AAA", "searchSuccess")
    }

    private fun searchFailure() {
        Log.d("AAA", "searchFailure")
    }
}