package com.example.android.githubbrowser.repository.api.response

data class Contributor(
    val login: String,
    val contributions: Int,
    val avatarUrl: String?
) {
    lateinit var repoName: String
    lateinit var repoOwner: String
}
