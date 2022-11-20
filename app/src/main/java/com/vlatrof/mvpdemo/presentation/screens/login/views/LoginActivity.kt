package com.vlatrof.mvpdemo.presentation.screens.login.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vlatrof.mvpdemo.R
import com.vlatrof.mvpdemo.databinding.ActivityLoginBinding
import com.vlatrof.mvpdemo.presentation.screens.login.presenters.LoginPresenter
import com.vlatrof.mvpdemo.presentation.screens.login.presenters.LoginPresenterImpl

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var binding: ActivityLoginBinding

    private val loginPresenter: LoginPresenter = LoginPresenterImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // attach view to presenter
        loginPresenter.attachView(view = this@LoginActivity)

        binding.btnSubmitLogin.setOnClickListener {
            // #1 send user action command to the presenter (to perform login)
            loginPresenter.login(
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString()
            )
        }
    }

    // #3 methods below are used by the presenter to show data to user

    override fun showSuccess() {
        val message = getString(R.string.toast_login_success)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showError(messageId: Int) {
        val message = getString(messageId)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
