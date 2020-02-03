package com.example.android.githubbrowser.repository.api

import com.example.android.githubbrowser.repository.api.response.Contributor
import com.example.android.githubbrowser.repository.api.response.Repo
import com.example.android.githubbrowser.repository.api.response.RepoSearchResponse
import com.example.android.githubbrowser.repository.api.response.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET("users/{login}")
    suspend fun getUser(
        @Path("login")
        login: String
    ): ApiResponse<User>

    @GET("users/{login}/repos")
    suspend fun getRepos(
        @Path("login")
        login: String
    ): ApiResponse<List<Repo>>

    @GET("repos/{owner}/{name}")
    suspend fun getRepo(
        @Path("owner")
        owner: String,
        @Path("name")
        name: String
    ): ApiResponse<Repo>

    @GET("repos/{owner}/{name}/contributors")
    suspend fun getContributors(
        @Path("owner")
        owner: String,
        @Path("name")
        name: String
    ): ApiResponse<List<Contributor>>

    @GET("search/repositories")
    suspend fun searchRepos(
        @Query("q")
        query: String
    ): RepoSearchResponse

    @GET("search/repositories")
    suspend fun searchRepos(
        @Query("q")
        query: String,
        @Query("page")
        page: Int
    ): RepoSearchResponse
}