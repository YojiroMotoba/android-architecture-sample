package com.example.android.githubbrowser.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ActivityDetailSampleBinding
import com.example.android.githubbrowser.ui.viewmodel.DetailSampleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailSampleActivity : AppCompatActivity() {

    private val viewModel: DetailSampleViewModel by viewModel()
    private lateinit var binding: ActivityDetailSampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_sample)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.exceptionButton.setOnClickListener {
            viewModel.exception()
        }
    }
}
