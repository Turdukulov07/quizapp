package com.example.quizapp.models

import java.io.Serializable

data class Request (
    var questionsNum: Int = 0,
    var category: Int = 0,
    var difficulty: String= "") : Serializable