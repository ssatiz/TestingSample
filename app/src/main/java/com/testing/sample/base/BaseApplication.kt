package com.testing.sample.base

import android.app.Application

/**
 * Created by SunTrust on 10/11/2018.
 */
class BaseApplication : Application() {

    companion object {
        private var instance: BaseApplication? = null
        fun getAppInstance(): BaseApplication? {
            if (instance == null) instance = BaseApplication()
            return instance
        }

    }
}