package com.example.quizapp.di.modules

import com.example.quizapp.repo.QuizRepository
import org.koin.dsl.module

val repoModule = module {
    single { QuizRepository(get()) }
}