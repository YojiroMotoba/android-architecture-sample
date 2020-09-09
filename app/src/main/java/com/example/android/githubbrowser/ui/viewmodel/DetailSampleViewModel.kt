package com.example.android.githubbrowser.ui.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.githubbrowser.interactor.GithubInteractor
import com.example.android.githubbrowser.logger
import com.example.android.githubbrowser.repository.api.response.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException

class DetailSampleViewModel(
    private val githubInteractor: GithubInteractor
) : ViewModel() {

    var repo = MutableLiveData<Repo>()
    val query = MutableLiveData<String>()

    fun exception() {
        viewModelScope.launch {
            githubInteractor.exceptionSample()
        }
    }

    @ExperimentalCoroutinesApi
    val onClickSearch = View.OnClickListener {
        viewModelScope.launch {
            logger("start githubInteractor.searchRepos")
            githubInteractor.searchRepos(query.value!!)
                .flowOn(Dispatchers.IO)
                .onEach { repoList ->
                    logger("onEach")
                    searchSuccess(repoList[0])
                }
                .onStart {
                    logger("onStart")
                }
                .onCompletion {
                    logger("onCompletion")
                }
                .catch { cause ->
                    logger("catch")
                    searchFailure(cause)
                }
                .collect()
        }
    }

    private fun searchMap(repo: List<Repo>): List<Repo> {
        Log.d("AAA", "searchMap")
        return repo
    }

    private fun searchSuccess(repo: Repo) {
        Log.d("AAA", "searchSuccess")
        this.repo.value = repo
    }

    private fun searchFailure(t: Throwable) {
        Log.e("AAA", t.message, t)
        if (t is HttpException) {
            Log.d("AAA", "code is ${t.code()}", t)
        }
    }
}
