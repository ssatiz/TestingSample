package com.testing.sample.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseActivity
import com.testing.sample.databinding.ActivityLoginBinding
import com.testing.sample.ui.forgetPassword.ForgetPasswordFragment
import com.testing.sample.ui.registration.RegistrationFragment

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginActivityViewModel>() {

    override fun getViewModel()=loginActVM

    override fun getBindingVariable()=BR.loginActVM

    override fun getContentView()=R.layout.activity_login

    private val loginActVM: LoginActivityViewModel by lazy {
        LoginActivityViewModel(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragment(LoginFragment.newInstance(), tagString = LoginFragment::class.java.name)
    }

    private fun setFragment(fragment: Fragment, isAddToBackStack: Boolean = false, tagString: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, fragment)
        if (isAddToBackStack) transaction.addToBackStack(tagString)
        transaction.commit()
    }

    fun redirectToFrogetPassword() {
        setFragment(ForgetPasswordFragment.newInstance(), true, tagString = ForgetPasswordFragment::class.java.name)
    }

    fun redirectToRegistration() {
        setFragment(RegistrationFragment.newInstance(), true, tagString = RegistrationFragment::class.java.name)
    }
}
