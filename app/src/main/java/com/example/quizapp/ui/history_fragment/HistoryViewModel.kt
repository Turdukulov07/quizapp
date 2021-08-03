package com.example.quizapp.ui.history_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quizapp.core.ui.base.BaseViewModel

class HistoryViewModel : BaseViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "History Fragment"
    }
    val text: LiveData<String> = _text
}