package com.example.android.githubbrowser.repository.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.githubbrowser.repository.db.entity.Token.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
class Token {

    internal companion object {
        const val TABLE_NAME: String = "token"
    }

    @PrimaryKey
    var id: Int = 0
    var accessToken: String = ""
    var refreshToken: String = ""
    var secureToken: String = ""
    var userAccessToken: String = ""
}