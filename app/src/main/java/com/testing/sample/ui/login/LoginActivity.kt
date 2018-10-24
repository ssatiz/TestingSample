package com.testing.sample.ui.login

import android.os.Bundle
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseActivity
import com.testing.sample.databinding.ActivityLoginBinding
import com.testing.sample.ui.forgetPassword.ForgetPasswordFragment
import com.testing.sample.ui.registration.RegistrationFragment

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginActivityViewModel>() {

    override fun getViewModel() = loginActVM

    override fun getBindingVariable() = BR.loginActVM

    override fun getContentView() = R.layout.activity_login

    private val loginActVM: LoginActivityViewModel by lazy {
        obtainViewModel(LoginActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragment(R.id.container, LoginFragment.newInstance(), tagString = LoginFragment::class.java.name)
    }

    fun redirectToForgetPassword() {
        setFragment(R.id.container, ForgetPasswordFragment.newInstance(), true, tagString = ForgetPasswordFragment::class.java.name)
    }

    fun redirectToRegistration() {
        setFragment(R.id.container, RegistrationFragment.newInstance(), true, tagString = RegistrationFragment::class.java.name)
    }
}
