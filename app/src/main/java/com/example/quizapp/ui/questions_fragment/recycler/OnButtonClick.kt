package com.example.quizapp.ui.questions_fragment.recycler

import android.view.View
import com.example.quizapp.models.Question

interface OnButtonClick {
    fun onBtnAnswerClick(view: View, item: Question, answer: String)
    fun onBtnSkipClick(view: View, item: Question)
}