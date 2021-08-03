package com.example.quizapp.models

import com.google.gson.annotations.SerializedName

data class QuestionQuiz (
    @SerializedName ("response_code") var responseCode: Int,
    @SerializedName ("results") var result: List<Question>)

data class Question (
    @SerializedName("category") var category: String,
    @SerializedName("type") var type: String,
    @SerializedName("difficulty") var difficulty: String,
    @SerializedName("question") var question: String,
    @SerializedName("correct_answer") var correctAnswer: String,
    @SerializedName("incorrect_answers") var incorrectAnswers: List<String>,
    var answer:String? = null,
    var isAnsweredCorrect: Boolean = false,
    var isAnsweredIncorrect: Boolean = false,
    var isSkipped: Boolean = false,
    var shuffledAnswers:List<String>)