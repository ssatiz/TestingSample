package com.testing.sample.repository.login

import com.testing.sample.repository.model.User

/**
 * Created by SunTrust on 10/16/2018.
 */
interface LoginSource {
    interface AuthenticationCallBack {
        fun onSuccess(): User
        fun onError(): String
    }

    fun authenticateUser(userName:String,password:String,callBack: AuthenticationCallBack)
}