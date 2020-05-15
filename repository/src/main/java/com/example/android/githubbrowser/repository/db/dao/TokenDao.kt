package com.example.android.githubbrowser.repository.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.githubbrowser.repository.db.entity.Token

@Dao
interface TokenDao {

    @Query("select * from ${Token.TABLE_NAME}")
    suspend fun select(): Token?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(token: Token)

    @Query("delete from ${Token.TABLE_NAME}")
    suspend fun delete(): Int
}