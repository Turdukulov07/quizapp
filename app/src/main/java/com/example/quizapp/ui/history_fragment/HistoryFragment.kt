package com.example.quizapp.ui.history_fragment

import com.example.quizapp.core.ui.base.BaseFragment
import com.example.quizapp.databinding.HistoryFragmentBinding
import org.koin.android.ext.android.inject

class HistoryFragment :
    BaseFragment<HistoryFragmentBinding, HistoryViewModel>(HistoryFragmentBinding::inflate) {
    override val viewModel by inject<HistoryViewModel>()

    companion object {
        fun getInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }

    override fun setUpUI() {
        viewModel.text.observe(viewLifecycleOwner, { text ->
            binding.tvHistory.text = text
        }
        )
    }

    override fun setUp() {

    }

    override fun setUpLiveData() {

    }
}