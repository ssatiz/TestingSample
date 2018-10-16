package com.testing.sample.ui.login

import android.app.Application
import com.testing.sample.base.BaseViewModel
import com.testing.sample.repository.Injection
import com.testing.sample.repository.login.LoginSource
import com.testing.sample.repository.model.User

class LoginFragmentViewModel(app: Application) : BaseViewModel(app) {
    private val loginDataManager = Injection.provideLoginDataManager(app)

    fun validateUser(userName: String, password: String) {
        loginDataManager.authenticateUser(userName, password, object : LoginSource.AuthenticationCallBack {
            override fun onSuccess(): User {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onError(): String {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}
