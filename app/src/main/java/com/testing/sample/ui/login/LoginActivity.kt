package com.testing.sample.ui.login

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseActivity
import com.testing.sample.base.BaseViewModel

class LoginActivity : BaseActivity<ViewDataBinding, BaseViewModel>() {

    override fun getViewModel(): BaseViewModel {
        return loginActVM
    }

    override fun getBindingVariable(): Int {
        return BR.loginActVM
    }

    override fun getContentView(): Int {
        return R.layout.login_activity
    }

    private val loginActVM: LoginActivityViewModel by lazy {
        LoginActivityViewModel(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragment()
    }

    private fun setFragment(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
    }

}
