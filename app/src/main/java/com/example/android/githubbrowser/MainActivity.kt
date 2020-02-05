package com.example.android.githubbrowser

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.android.githubbrowser.ui.DebugActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : InjectorAppCompatActivity(R.layout.activity_main) {

    private val mainViewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        request_button.setOnClickListener { request() }
        insert_button.setOnClickListener { insert() }
        select_button.setOnClickListener { select() }
        delete_button.setOnClickListener { delete() }
        debug_button.setOnClickListener { startDebug() }
    }

    private fun request() {
        mainViewModel.searchRepos()
    }

    private fun insert() {
        mainViewModel.insert()
    }

    private fun select() {
        mainViewModel.select()
    }

    private fun delete() {
        mainViewModel.delete()
    }

    private fun startDebug() {
        startActivity(Intent(this@MainActivity, DebugActivity::class.java))
    }
}