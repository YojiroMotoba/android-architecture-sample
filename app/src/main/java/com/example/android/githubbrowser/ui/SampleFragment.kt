package com.example.android.githubbrowser.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.android.githubbrowser.InjectorFragment
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.ui.viewmodel.SampleFragmentViewModel

class SampleFragment : InjectorFragment(R.layout.fragment_sample) {
    private val viewModel: SampleFragmentViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.search("dd")
    }
}
