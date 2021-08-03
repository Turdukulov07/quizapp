package com.example.quizapp.ui.questions_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quizapp.core.ui.base.BaseViewModel
import com.example.quizapp.models.QuestionQuiz
import com.example.quizapp.repo.QuizRepository
import kotlinx.coroutines.launch
import org.json.JSONObject

class QuestionViewModel(private val repo: QuizRepository) : BaseViewModel() {
    var quizLiveData = MutableLiveData<QuestionQuiz>()
    var errorLiveData = MutableLiveData<ArrayList<String>>()

    fun getQuiz() {
        viewModelScope.launch {
            val response = repo.getQuiz()
            if (response != null) {
                if (response.isSuccessful) {
                    val quiz = response.body()
                    quiz?.result?.forEach {
                        val answers: ArrayList<String> = ArrayList()
                        if (it.type == "multiple") {
                            answers.add(it.correctAnswer)
                            answers.add(it.incorrectAnswers[0])
                            answers.add(it.incorrectAnswers[1])
                            answers.add(it.incorrectAnswers[2])
                        }

                        if (it.type == "boolean") {
                            answers.add(it.correctAnswer)
                            answers.add(it.incorrectAnswers[0])
                        }
                        answers.shuffle()
                        it.shuffledAnswers = answers
                    }
                    quizLiveData.value = quiz!!

                } else {
                    try {
                        val json = JSONObject(response.errorBody().toString())
                        val errors: ArrayList<String> = ArrayList()
                        json.keys().forEach {
                            errors.add(json.get(it).toString())
                        }
                        errorLiveData.value = errors
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            } else {
                errorLiveData.value = arrayListOf("Подключитесь к интернету")
            }
        }
    }
}