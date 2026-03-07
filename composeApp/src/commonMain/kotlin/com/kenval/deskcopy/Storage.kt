package com.kenval.deskcopy

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Storage {
    private val _state = MutableStateFlow("")
    val state: StateFlow<String> = _state.asStateFlow()

    private val _mirrorMessage = MutableStateFlow("")
    val message get() = _mirrorMessage.asStateFlow()

    suspend fun updateMessage(value: String) {
        _state.emit(value)
    }

    suspend fun updateMirrorMessage(value: String) {
        _mirrorMessage.emit(value)
    }
}