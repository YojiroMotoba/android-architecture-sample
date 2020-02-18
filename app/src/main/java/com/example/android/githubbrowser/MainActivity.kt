package com.example.android.githubbrowser

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.android.githubbrowser.databinding.ActivityMainBinding
import com.example.android.githubbrowser.ui.DebugActivity

class MainActivity : InjectorAppCompatActivity(R.layout.activity_main) {

    private val mainViewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel

        mainViewModel.debugClick.observe(this, Observer { startDebug() })
    }

    private fun startDebug() {
        startActivity(Intent(this@MainActivity, DebugActivity::class.java))
    }
}