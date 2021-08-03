package com.example.quizapp.ui.settings_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quizapp.core.ui.base.BaseViewModel

class SettingsViewModel : BaseViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Settings Fragment"
    }
    val text: LiveData<String> = _text
}