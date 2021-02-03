package com.example.android.githubbrowser.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ActivityEmptyBinding


class EmptyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmptyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_empty)
        binding.fragment.setOnClickListener {
            supportFragmentManager.beginTransaction().let {
                it.replace(R.id.container, SampleFragment())
                it.commit()
            }
        }
    }
}