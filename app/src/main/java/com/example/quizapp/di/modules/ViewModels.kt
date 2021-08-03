package com.example.quizapp.di.modules

import com.example.quizapp.ui.history_fragment.HistoryViewModel
import com.example.quizapp.ui.main_fragment.MainViewModel
import com.example.quizapp.ui.questions_fragment.QuestionViewModel
import com.example.quizapp.ui.quiz_fragment.QuizViewModel
import com.example.quizapp.ui.settings_fragment.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { QuizViewModel(get()) }
    viewModel { HistoryViewModel() }
    viewModel { SettingsViewModel() }
    viewModel { MainViewModel() }
    viewModel { QuestionViewModel(get()) }
}
