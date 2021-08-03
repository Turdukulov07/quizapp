package com.example.quizapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val ui: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_QuizApp)
        setContentView(ui.root)
    }
}