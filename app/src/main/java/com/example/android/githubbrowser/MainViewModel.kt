package com.example.android.githubbrowser

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.api.response.RepoSearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel @Inject constructor(private val githubApi: GithubApi) : ViewModel() {

    fun searchRepos() {
        val searchReposRes: Call<RepoSearchResponse> = githubApi.searchRepos("test")
        searchReposRes.enqueue(object : Callback<RepoSearchResponse> {
            override fun onFailure(call: Call<RepoSearchResponse>, t: Throwable) {
                Log.e("motoba", "motoba", t)
            }

            override fun onResponse(
                call: Call<RepoSearchResponse>,
                response: Response<RepoSearchResponse>
            ) {
                Log.i("motoba", "motoba")
                if (response.isSuccessful) {
                    val repoSearchResponse: RepoSearchResponse? = response.body()
                    repoSearchResponse?.let { it ->
                        Log.i("motoba", it.items[0].description)
                    }
                }
            }
        })
    }
}