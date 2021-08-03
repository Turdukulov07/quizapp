package com.example.quizapp

import android.app.Application
import com.example.quizapp.di.modules.modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class QuizApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@QuizApp)
            modules(modules)
        }
    }
}