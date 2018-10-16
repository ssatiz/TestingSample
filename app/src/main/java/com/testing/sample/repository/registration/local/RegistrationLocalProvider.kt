package com.testing.sample.repository.registration.local

import android.content.Context
import com.testing.sample.base.BaseApplication
import com.testing.sample.repository.model.User
import com.testing.sample.repository.registration.RegistrationSource

/**
 * Created by SunTrust on 10/16/2018.
 */
object RegistrationLocalProvider:RegistrationSource {
    override fun saveUserDetail(user: User, callBack: RegistrationSource.RegistrationCallBack) {
        BaseApplication.getAppInstance()?.getSharedPreferences("",Context.MODE_PRIVATE)
    }
}