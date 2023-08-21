package com.example.cnorrisp.ui.states

sealed class UIState{
    data class Error(var e : Throwable):UIState()
    object Loading:UIState()
    object Success:UIState()
}
