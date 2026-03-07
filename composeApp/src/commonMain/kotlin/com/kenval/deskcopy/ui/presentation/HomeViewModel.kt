package com.kenval.deskcopy.ui.presentation

import com.kenval.deskcopy.data.MessageRepository
import com.kenval.deskcopy.data.source.remote.MirrorMessageStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class HomeViewModel(
    private val repository: MessageRepository,
    private val mirrorMessageStorage: MirrorMessageStorage
) : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState.EMPTY)
    val state get() = _state.asStateFlow()

    val mirrorMessage get() = mirrorMessageStorage.message

    fun onEntered() {
        update {
            val ip = repository.getIpAddress()
            ip?.let {
                copy(ipAddress = it)
            } ?: copy()
        }
    }

    fun onMessageChange(message: String) {
        update { copy(message = message) }
    }

    fun onMirrorMessageChange(message: String) {
        viewModelScope.launch {
            mirrorMessageStorage.message.emit(message)
        }
    }

    fun onMessageSendConfirm() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.sendMessage(_state.value.message)
            } catch (_: Exception) {
                update { copy(statusMessage = "Cannot connect to the local IP address. Check if it is a valid address.") }
            }
        }
    }

    fun subscribeToMessages() {
        viewModelScope.launch {
            try {
                repository.subscribeToMessages()
            } catch (_: Exception) {

            }
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
            update { copy(statusMessage = "IP address has been saved.")}
        }
    }

    fun resetStatusMessage() {
        update { copy(statusMessage = null) }
    }

    private fun update(updateViewState: HomeViewState.() -> HomeViewState) {
        viewModelScope.launch {
            _state.update {
                updateViewState(_state.value)
            }
        }
    }
}