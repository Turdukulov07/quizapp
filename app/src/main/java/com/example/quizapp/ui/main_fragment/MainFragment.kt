package com.example.quizapp.ui.main_fragment

import com.example.quizapp.R
import com.example.quizapp.core.ui.base.BaseFragment
import com.example.quizapp.databinding.MainFragmentBinding
import org.koin.android.ext.android.inject

class MainFragment :
    BaseFragment<MainFragmentBinding, MainViewModel>(MainFragmentBinding::inflate) {
    override val viewModel by inject<MainViewModel>()

    override fun setUpUI() {
        binding.navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_quiz -> {
                    binding.viewPager.currentItem = 0
                    item.isChecked = true
                }
                R.id.navigation_history -> {
                    binding.viewPager.currentItem = 1
                    item.isChecked = true
                }
                R.id.navigation_settings -> {
                    binding.viewPager.currentItem = 2
                    item.isChecked = true
                }
            }
            false
        }
        binding.viewPager.isUserInputEnabled = false
    }

    override fun setUp() {
        val adapter: ViewPagerAdapter by lazy {
            ViewPagerAdapter(requireActivity())
        }
        binding.viewPager.adapter = adapter
    }

    override fun setUpLiveData() {

    }

}