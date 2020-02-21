package com.example.android.githubbrowser.ui.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.githubbrowser.repository.db.dao.TokenDao
import com.example.android.githubbrowser.repository.db.entity.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomSampleViewModel @Inject constructor(
    private val tokenDao: TokenDao
) : ViewModel() {

    val token = MutableLiveData<Token>()
    val accessTokenText = MutableLiveData<String>()

    val insert = View.OnClickListener {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                tokenDao.insert(Token().also {
                    it.accessToken = accessTokenText.value!!
                })
            }
        }
    }

    val select = View.OnClickListener {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                token.postValue(tokenDao.select())
            }
        }
    }
}