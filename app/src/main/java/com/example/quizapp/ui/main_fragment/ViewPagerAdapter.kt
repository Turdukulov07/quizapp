package com.example.quizapp.ui.main_fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.quizapp.ui.history_fragment.HistoryFragment
import com.example.quizapp.ui.quiz_fragment.QuizFragment
import com.example.quizapp.ui.settings_fragment.SettingsFragment
import java.util.*

class ViewPagerAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    private val fragmentList: MutableList<Fragment> = ArrayList()

    init {
        fragmentList.add(QuizFragment.getInstance())
        fragmentList.add(HistoryFragment.getInstance())
        fragmentList.add(SettingsFragment.getInstance())
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }
}

