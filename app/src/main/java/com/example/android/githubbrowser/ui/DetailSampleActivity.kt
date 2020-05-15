package com.example.android.githubbrowser.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.ActivityDetailSampleBinding
import com.example.android.githubbrowser.ui.viewmodel.DetailSampleViewModel
import kotlinx.android.synthetic.main.activity_detail_sample.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailSampleActivity : AppCompatActivity() {

    private val viewModel: DetailSampleViewModel by viewModel()

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
