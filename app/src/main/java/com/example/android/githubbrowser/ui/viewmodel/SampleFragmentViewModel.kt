package com.example.android.githubbrowser.ui.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.githubbrowser.interactor.GithubInteractor
import com.example.android.githubbrowser.repository.api.response.Repo
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SampleFragmentViewModel(
    private val githubInteractor: GithubInteractor
) : ViewModel() {

    val query = MutableLiveData<String>()
    val result_id = MutableLiveData<String>()

    val onClickSearch = View.OnClickListener {
        viewModelScope.launch {
            githubInteractor.searchRepos(query.value!!)
                .catch {
                    searchFailure(it)
                }
                .collect {
                    searchSuccess(it[0])
                }
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
