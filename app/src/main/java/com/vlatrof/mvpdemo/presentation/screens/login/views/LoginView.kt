package com.vlatrof.mvpdemo.presentation.screens.login.views

interface LoginView {
    fun showSuccess()
    fun showError(messageId: Int)
}
