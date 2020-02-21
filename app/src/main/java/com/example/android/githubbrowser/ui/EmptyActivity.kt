package com.example.android.githubbrowser.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.githubbrowser.R
import kotlinx.android.synthetic.main.activity_empty.*


class EmptyActivity : AppCompatActivity(R.layout.activity_empty) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragment.setOnClickListener {
            supportFragmentManager.beginTransaction().let {
                it.replace(R.id.container, SampleFragment())
                it.commit()
            }
        }
    }
}