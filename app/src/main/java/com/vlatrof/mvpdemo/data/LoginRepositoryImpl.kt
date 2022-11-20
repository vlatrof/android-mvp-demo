package com.vlatrof.mvpdemo.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class LoginRepositoryImpl : LoginRepository {
    override fun performLogin(email: String, password: String): Deferred<String> {
        return CoroutineScope(Dispatchers.IO).async { // dummy logic
            delay(3000L)
            return@async ""
        }
    }
}
