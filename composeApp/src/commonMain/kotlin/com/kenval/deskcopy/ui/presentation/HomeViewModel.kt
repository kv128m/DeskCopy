package com.kenval.deskcopy.ui.presentation

import com.kenval.deskcopy.data.MessageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class HomeViewModel(
    private val repository: MessageRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState.EMPTY)
    val state get() = _state.asStateFlow()

    fun onMessageChange(message: String) {
        update { copy(message = message) }
    }

    fun onMessageSendConfirm() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.sendMessage(_state.value.message)
        }
    }

    fun onSettingsClick() {
        update { copy(settingsExpanded = !settingsExpanded) }
    }

    fun onIpAddressChange(value: String) {
        update { copy(ipAddress = value) }
    }

    fun onIpAddressChangeConfirm() {
        update { copy(settingsExpanded = false) }
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveIpAddress(_state.value.ipAddress)
        }
    }

    private fun update(updateViewState: HomeViewState.() -> HomeViewState) {
        viewModelScope.launch {
            _state.update {
                updateViewState(_state.value)
            }
        }
    }
}