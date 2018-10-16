package com.testing.sample.repository.registration

import com.testing.sample.repository.model.User

/**
 * Created by SunTrust on 10/16/2018.
 */
interface RegistrationSource {
    fun saveUserDetail(user: User, callBack: RegistrationCallBack)

    interface RegistrationCallBack {
        fun onSuccess(): String
        fun onError(): String
    }
}