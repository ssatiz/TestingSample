package com.testing.sample.ui.login

import android.app.Application
import com.testing.sample.base.BaseViewModel
import com.testing.sample.repository.Injection

class LoginFragmentViewModel(app: Application) : BaseViewModel(app){
    private val loginDataManager = Injection.provideLoginDataManager(app)
}
