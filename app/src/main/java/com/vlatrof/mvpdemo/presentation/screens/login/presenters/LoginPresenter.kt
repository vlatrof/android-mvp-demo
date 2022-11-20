package com.vlatrof.mvpdemo.presentation.screens.login.presenters

import com.vlatrof.mvpdemo.presentation.screens.login.views.LoginView

interface LoginPresenter {
    fun attachView(view: LoginView)
    fun login(email: String, password: String)
}
