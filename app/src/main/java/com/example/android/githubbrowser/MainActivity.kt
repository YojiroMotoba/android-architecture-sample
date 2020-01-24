package com.example.android.githubbrowser

import android.os.Bundle
import android.util.Log
import com.example.android.githubbrowser.repository.api.GithubApi
import com.example.android.githubbrowser.repository.api.response.RepoSearchResponse
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : InjectorAppCompatActivity(R.layout.activity_main), HasAndroidInjector {

    @Inject
    lateinit var githubApi: GithubApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        request_button.setOnClickListener { request() }
    }

    private fun request() {
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