package com.kenval.deskcopy.ui.presentation

data class HomeViewState(
    val message: String,
    val ipAddress: String,
    val settingsExpanded: Boolean
) {
    companion object {
        val EMPTY = HomeViewState(
            message = "",
            ipAddress = "",
            settingsExpanded = false
        )
    }
}
