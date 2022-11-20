package com.vlatrof.mvpdemo.data

import kotlinx.coroutines.Deferred

interface LoginRepository {
    fun performLogin(email: String, password: String): Deferred<String>
}
