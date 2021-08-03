package com.example.quizapp.ui.settings_fragment

import com.example.quizapp.core.ui.base.BaseFragment
import com.example.quizapp.databinding.SettingsFragmentBinding
import org.koin.android.ext.android.inject

class SettingsFragment :
    BaseFragment<SettingsFragmentBinding, SettingsViewModel>(SettingsFragmentBinding::inflate) {
    override val viewModel by inject<SettingsViewModel>()

    companion object {
        fun getInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    override fun setUpUI() {
        viewModel.text.observe(viewLifecycleOwner, { text ->
            binding.tvSettings.text = text
        })
    }

    override fun setUp() {
    }

    override fun setUpLiveData() {

    }

}