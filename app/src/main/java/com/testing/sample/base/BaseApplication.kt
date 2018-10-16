package com.testing.sample.base

import android.app.Application

/**
 * Created by SunTrust on 10/11/2018.
 */
class BaseApplication : Application() {

    companion object {
        private var INSTANCE: BaseApplication? = null
        fun getAppInstance(): BaseApplication? {
            if (INSTANCE == null) INSTANCE = BaseApplication()
            return INSTANCE
        }

    }
}