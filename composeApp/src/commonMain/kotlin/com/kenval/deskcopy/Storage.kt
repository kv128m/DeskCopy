package com.kenval.deskcopy

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Storage {
    private val _state = MutableStateFlow("")
    val state: StateFlow<String> = _state.asStateFlow()

    suspend fun updateMessage(value: String) {
        _state.emit(value)
    }
}