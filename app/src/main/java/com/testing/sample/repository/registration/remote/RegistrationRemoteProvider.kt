package com.testing.sample.repository.registration.remote

import com.testing.sample.repository.model.User
import com.testing.sample.repository.registration.RegistrationSource

/**
 * Created by SunTrust on 10/16/2018.
 */
object RegistrationRemoteProvider: RegistrationSource {
    override fun saveUserDetail(user: User, callBack: RegistrationSource.RegistrationCallBack) {
    }
}