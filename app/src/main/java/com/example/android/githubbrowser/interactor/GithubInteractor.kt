package com.example.android.githubbrowser.interactor

import com.example.android.githubbrowser.repository.api.response.Repo

interface GithubInteractor {
    suspend fun searchRepos(query: String): List<Repo>
}
