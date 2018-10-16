package com.testing.sample.repository.registration

import com.testing.sample.repository.model.User
import com.testing.sample.repository.registration.local.RegistrationLocalProvider
import com.testing.sample.repository.registration.remote.RegistrationRemoteProvider

/**
 * Created by SunTrust on 10/16/2018.
 */
class RegistrationDataManager(val remoteProvider:RegistrationRemoteProvider,val localProvider:RegistrationLocalProvider):RegistrationSource {
    override fun saveUserDetail(user: User, callBack: RegistrationSource.RegistrationCallBack) {
        localProvider.saveUserDetail(user,callBack)
    }

    companion object {
        private var INSTANCE: RegistrationDataManager? = null
        fun getInstance(remoteProvider: RegistrationRemoteProvider, localProvider: RegistrationLocalProvider) = INSTANCE
                ?: synchronized(RegistrationDataManager::class.java) {
                    INSTANCE ?: RegistrationDataManager(remoteProvider, localProvider)
                            .also { INSTANCE = it }
                }
    }
}