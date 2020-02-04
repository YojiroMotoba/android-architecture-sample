package com.example.android.githubbrowser

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.api.response.RepoSearchResponse
import com.example.android.githubbrowser.repository.db.dao.TokenDao
import com.example.android.githubbrowser.repository.db.entity.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val githubApi: GithubApi,
    private val tokenDao: TokenDao
) : ViewModel() {

    fun searchRepos() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val res = githubApi.searchRepos("test")
                logtest(res)
                res
            }
                .onSuccess { searchReposSuccess(it) }
                .onFailure { searchReposFailure(it) }
                .also { searchReposAlso(it) }
        }
    }

    fun insert() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                tokenDao.insert(Token().also {
                    it.accessToken = "accessToken"
                })
            }
                .onSuccess { insertSuccess() }
                .onFailure { insertFailure(it) }
        }
    }

    fun select() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                tokenDao.select()
            }
                .onSuccess { selectSuccess(it) }
                .onFailure { selectFailure(it) }
        }
    }

    fun delete() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                tokenDao.delete()
            }
                .onSuccess { deleteSuccess(it) }
                .onFailure { deleteFailure(it) }
        }
    }

    private fun deleteSuccess(delete_count: Int) {
        Log.d("AAA", "DELETE Success $delete_count")
    }

    private fun deleteFailure(t: Throwable) {
        Log.d("AAA", "DELETE Failure ${t.message}", t)
    }

    private fun insertSuccess() {
        Log.d("AAA", "INSERT Success")
    }

    private fun insertFailure(t: Throwable) {
        Log.d("AAA", "INSERT Failure ${t.message}", t)
    }

    private fun selectSuccess(token: Token?) {
        Log.d("AAA", "select Success")
        if (token != null) {
            Log.d("AAA", "accessToken=${token.accessToken}")
        } else {
            Log.d("AAA", "result not found")
        }
    }

    private fun selectFailure(t: Throwable) {
        Log.d("AAA", "select Failure ${t.message}", t)
    }

    private fun logtest(res: RepoSearchResponse) {
        Log.d("AAA", Thread.currentThread().name)
        res.items.forEach {
            it.let { }
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
