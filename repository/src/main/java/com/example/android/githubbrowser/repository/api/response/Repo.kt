package com.example.android.githubbrowser.repository.api.response

data class
Repo(
    val id: Int,
    val name: String,
    val fullName: String,
    val description: String?,
    val owner: Owner,
    val stars: Int
) {

    data class Owner(
        val login: String,
        val url: String?
    )

    companion object {
        const val UNKNOWN_ID = -1
    }
}
