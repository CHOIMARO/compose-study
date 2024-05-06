package com.choimaro.compose_study.intro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor() : ViewModel() {
    private val _isReady = MutableSharedFlow<Boolean>()
    val isReady = _isReady.asSharedFlow()
    init {
        viewModelScope.launch {
            delay(3000)
            _isReady.emit(true)
        }
    }
}