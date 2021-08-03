package com.example.quizapp.frameworks.remote

import com.example.quizapp.models.Category
import com.example.quizapp.models.QuestionQuiz
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizAPI {

    @GET(Constants.API_CATEGORY_PHP)
    suspend fun getCategory(
    ): Response<Category>

    @GET(Constants.API_PHP)
    suspend fun getQuestions(
        @Query(Constants.AMOUNT) amount: Int,
        @Query(Constants.CATEGORY) category: Int,
        @Query(Constants.DIFFICULTY) difficulty: String
    ): Response<QuestionQuiz>

}