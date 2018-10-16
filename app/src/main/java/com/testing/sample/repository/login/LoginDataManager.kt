package com.testing.sample.repository.login

import com.testing.sample.repository.login.local.LoginLocalProvider
import com.testing.sample.repository.login.remote.LoginRemoteProvider

/**
 * Created by SunTrust on 10/16/2018.
 */
class LoginDataManager(val remoteProvider: LoginRemoteProvider,val localProvider: LoginLocalProvider) {
    companion object {
        private var INSTANCE: LoginDataManager? = null
        fun getInstance(remoteProvider: LoginRemoteProvider, localProvider: LoginLocalProvider)=INSTANCE ?: synchronized(LoginDataManager::class.java) {
            INSTANCE ?: LoginDataManager(remoteProvider, localProvider)
                    .also { INSTANCE = it }
        }
    }
}