package com.testing.sample.repository.login.remote

import com.testing.sample.repository.login.LoginSource

/**
 * Created by SunTrust on 10/16/2018.
 */
object LoginRemoteProvider : LoginSource {
    override fun authenticateUser(userName: String, password: String, callBack: LoginSource.AuthenticationCallBack) {
    }

}