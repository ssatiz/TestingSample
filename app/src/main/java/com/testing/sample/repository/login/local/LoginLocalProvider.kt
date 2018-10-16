package com.testing.sample.repository.login.local

import com.testing.sample.repository.login.LoginSource

/**
 * Created by SunTrust on 10/16/2018.
 */
object LoginLocalProvider : LoginSource {
    override fun authenticateUser(userName: String, password: String, callBack: LoginSource.AuthenticationCallBack) {
    }
}