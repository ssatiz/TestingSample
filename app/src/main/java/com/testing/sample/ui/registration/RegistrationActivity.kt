package com.testing.sample.ui.registration

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseActivity
import com.testing.sample.base.BaseViewModel

class RegistrationActivity : BaseActivity<ViewDataBinding, BaseViewModel>() {
    override fun getViewModel(): BaseViewModel {
        return registrationActVM
    }

    override fun getBindingVariable(): Int {
        return BR.registrationActVM
    }

    override fun getContentView(): Int {
        return R.layout.registration_activity
    }

    private val registrationActVM: RegistrationActivityViewModel by lazy {
        RegistrationActivityViewModel(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragment()
    }

    private fun setFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, RegistrationFragment.newInstance())
                .commitNow()
    }

}
