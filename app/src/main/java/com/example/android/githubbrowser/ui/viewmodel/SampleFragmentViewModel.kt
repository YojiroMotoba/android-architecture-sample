package com.example.android.githubbrowser.ui.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.githubbrowser.interactor.GithubInteractor
import com.example.android.githubbrowser.repository.api.response.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SampleFragmentViewModel(
    val githubInteractor: GithubInteractor
) : ViewModel() {

    val query = MutableLiveData<String>()
    val result_id = MutableLiveData<String>()

    val onClickSearch = View.OnClickListener {
        Log.d("AAA", "onClickSearch ${query.value!!}")
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    githubInteractor.searchRepos(query.value!!)
                }
            }
                .onSuccess { searchSuccess(it[0]) }
                .onFailure { searchFailure(it) }
        }
    }

    private fun searchSuccess(repo: Repo) {
        Log.d("AAA", "searchSuccess ${repo.id}")
        result_id.value = repo.id.toString()
    }

    private fun searchFailure(throwable: Throwable) {
        Log.e("AAA", throwable.message, throwable)
    }
}
