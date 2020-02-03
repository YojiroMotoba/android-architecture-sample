package com.example.android.githubbrowser.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.githubbrowser.repository.db.dao.TokenDao
import com.example.android.githubbrowser.repository.db.entity.Token

@Database(
    entities = [
        Token::class
    ],
    version = 1,
    exportSchema = false
)
abstract class GithubDatabase : RoomDatabase() {

    abstract fun tokenDao(): TokenDao
}