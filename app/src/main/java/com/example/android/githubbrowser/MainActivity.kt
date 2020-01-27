package com.example.android.githubbrowser

import android.os.Bundle
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : InjectorAppCompatActivity(R.layout.activity_main) {

    private val mainViewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        request_button.setOnClickListener { request() }
    }

    private fun request() {
        mainViewModel.searchRepos()
    }
}