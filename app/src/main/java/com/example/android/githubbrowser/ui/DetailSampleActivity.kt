package com.example.android.githubbrowser.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.android.githubbrowser.InjectorAppCompatActivity
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ActivityDetailSampleBinding
import com.example.android.githubbrowser.ui.viewmodel.DetailSampleViewModel
import kotlinx.android.synthetic.main.activity_detail_sample.*

class DetailSampleActivity : InjectorAppCompatActivity() {

    private val viewModel: DetailSampleViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityDetailSampleBinding>(
            this,
            R.layout.activity_detail_sample
        ).let {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }

        exception_button.setOnClickListener {
            viewModel.exception()
        }
    }
}
