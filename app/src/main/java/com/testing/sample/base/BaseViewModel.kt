package com.testing.sample.base

import android.content.Context
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    open fun initialize(context: Context) {
    }

}