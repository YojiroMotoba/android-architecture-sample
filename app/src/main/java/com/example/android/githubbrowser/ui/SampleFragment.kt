package com.example.android.githubbrowser.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.githubbrowser.R
import com.example.android.githubbrowser.databinding.FragmentSampleBinding
import com.example.android.githubbrowser.ui.viewmodel.SampleFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SampleFragment : Fragment() {

    private val viewModel: SampleFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<FragmentSampleBinding>(
            inflater,
            R.layout.fragment_sample,
            container,
            false
        ).also {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }.root

}
