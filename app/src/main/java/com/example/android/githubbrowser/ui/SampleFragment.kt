package com.example.android.githubbrowser.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.android.githubbrowser.InjectorFragment
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.FragmentSampleBinding
import com.example.android.githubbrowser.ui.viewmodel.SampleFragmentViewModel

class SampleFragment : InjectorFragment(R.layout.fragment_sample) {

    private val viewModel: SampleFragmentViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSampleBinding>(
            inflater,
            R.layout.fragment_sample,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }
}
