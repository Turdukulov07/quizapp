package com.example.quizapp.models

import com.google.gson.annotations.SerializedName

data class Category (
    @SerializedName("trivia_categories") var categories: List<TriviaCategories>)

data class TriviaCategories (
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String)