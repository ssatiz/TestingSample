package com.testing.sample.ui.forgetPassword

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseActivity
import com.testing.sample.base.BaseViewModel

class ForgetPasswordActivity : BaseActivity<ViewDataBinding, BaseViewModel>() {
    override fun getViewModel(): BaseViewModel {
        return forgetPasswordActVM
    }

    override fun getBindingVariable(): Int {
        return BR.forgetPasswordActVM
    }

    override fun getContentView(): Int {
        return R.layout.forget_password_activity
    }

    private val forgetPasswordActVM: ForgetPasswordActivityViewModel by lazy {
        ForgetPasswordActivityViewModel(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ForgetPasswordFragment.newInstance())
                    .commitNow()
        }
    }
}
