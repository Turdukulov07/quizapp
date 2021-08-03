package com.example.quizapp.ui.questions_fragment.recycler

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager


class CustomLinearLayoutManager(context: Context?) :
    LinearLayoutManager(context) {
    private var isScrollEnabled = true

    fun setScrollEnabled(flag: Boolean) {
        isScrollEnabled = flag
    }


    override fun canScrollHorizontally(): Boolean {
        return isScrollEnabled && super.canScrollHorizontally()
    }

}