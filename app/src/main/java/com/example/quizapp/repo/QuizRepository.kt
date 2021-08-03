package com.example.quizapp.repo

import com.example.quizapp.frameworks.remote.QuizAPI
import com.example.quizapp.models.QuestionQuiz
import com.example.quizapp.models.Request
import retrofit2.Response

class QuizRepository(private val api: QuizAPI) {
    var request: Request = Request()


    suspend fun getCategory() = api.getCategory()
    suspend fun getQuiz(): Response<QuestionQuiz>? {
        return try {
            api.getQuestions(request.questionsNum, request.category, request.difficulty)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}