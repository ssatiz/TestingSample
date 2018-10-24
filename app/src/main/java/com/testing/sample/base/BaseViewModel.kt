package com.testing.sample.base

import android.content.Context
import androidx.lifecycle.ViewModel

/**
 * Created by SunTrust on 10/11/2018.
 */
abstract class BaseViewModel : ViewModel() {

    open fun initialize(context: Context) {
    }

}