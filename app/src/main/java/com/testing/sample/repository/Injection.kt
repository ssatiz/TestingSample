package com.testing.sample.repository

import android.content.Context
import com.testing.sample.repository.login.LoginDataManager
import com.testing.sample.repository.login.local.LoginLocalProvider
import com.testing.sample.repository.login.remote.LoginRemoteProvider
import com.testing.sample.repository.registration.RegistrationDataManager
import com.testing.sample.repository.registration.local.RegistrationLocalProvider
import com.testing.sample.repository.registration.remote.RegistrationRemoteProvider

/**
 * Created by SunTrust on 10/16/2018.
 */
object Injection {
    fun provideLoginDataManager(context: Context) = LoginDataManager.getInstance(LoginRemoteProvider, LoginLocalProvider)
    fun provideRegistrationDataManger(context: Context) = RegistrationDataManager.getInstance(RegistrationRemoteProvider, RegistrationLocalProvider)
}