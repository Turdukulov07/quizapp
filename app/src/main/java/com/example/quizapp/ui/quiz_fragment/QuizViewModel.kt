package com.example.quizapp.ui.quiz_fragment

import androidx.lifecycle.liveData
import com.example.quizapp.core.ui.base.BaseViewModel
import com.example.quizapp.repo.QuizRepository
import kotlinx.coroutines.Dispatchers

class QuizViewModel(private val repo: QuizRepository) : BaseViewModel() {
    private val _request = repo.request

    fun getCategory() = liveData(Dispatchers.IO) {
        emit(repo.getCategory())
    }

    fun setQuestionNum(amount: Int) {
        _request.questionsNum = amount
    }

    fun setCategory(category: Int) {
        _request.category = category
    }

    fun setDifficulty(difficulty: String) {
        _request.difficulty = difficulty
    }

}