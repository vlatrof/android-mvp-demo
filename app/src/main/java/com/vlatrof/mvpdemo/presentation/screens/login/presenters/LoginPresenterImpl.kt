package com.vlatrof.mvpdemo.presentation.screens.login.presenters

import com.vlatrof.mvpdemo.R
import com.vlatrof.mvpdemo.data.LoginRepository
import com.vlatrof.mvpdemo.data.LoginRepositoryImpl
import com.vlatrof.mvpdemo.presentation.screens.login.views.LoginView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class LoginPresenterImpl : LoginPresenter {

    private val loginRepository: LoginRepository = LoginRepositoryImpl()
    private var loginView: WeakReference<LoginView>? = null

    override fun attachView(view: LoginView) {
        loginView = WeakReference(view)
    }

    // logic to perform user's action by #1
    override fun login(email: String, password: String) {
        if (!validateEmail(email = email)) {
            loginView?.get()?.showError(messageId = R.string.toast_login_invalid_email)
            return
        }
        if (!validatePassword(password = password)) {
            loginView?.get()?.showError(messageId = R.string.toast_login_invalid_password)
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            // #2 Presenter interacts with model (dummy logic)
            val errorMessage = loginRepository.performLogin(email, password).await()
            // calling view's methods to show data to user (#3)
            if (errorMessage.isEmpty()) {
                loginView?.get()?.showSuccess()
            } else {
                loginView?.get()?.showError(R.string.toast_login_wrong_data)
            }
        }
    }

    // Internal presenter logic:

    fun validateEmail(email: String): Boolean {
        if (!email.contains('@')) return false
        return true
    }

    fun validatePassword(password: String): Boolean {
        if (password.length < 6) return false
        return true
    }
}
