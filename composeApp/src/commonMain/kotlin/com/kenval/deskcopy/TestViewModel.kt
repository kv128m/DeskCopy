package com.kenval.deskcopy

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class TestViewModel(

) : ViewModel() {
    private val _state = MutableStateFlow<String>("")
    val state get() = _state.asStateFlow()

    fun update(value: String) {
        viewModelScope.launch {
            _state.update {
                value
            }
        }
    }
}