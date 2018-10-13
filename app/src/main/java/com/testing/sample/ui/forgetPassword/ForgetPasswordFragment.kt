package com.testing.sample.ui.forgetPassword

import androidx.databinding.ViewDataBinding
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseApplication
import com.testing.sample.base.BaseFragment
import com.testing.sample.base.BaseViewModel

class ForgetPasswordFragment : BaseFragment<ViewDataBinding, BaseViewModel>() {
    override fun getViewModel(): BaseViewModel {
        return forgetPasswordFragVM
    }

    override fun getBindingVariable(): Int {
        return BR.forgetPasswordFragVM
    }

    override fun getContentView(): Int {
        return R.layout.forget_password_fragment
    }

    companion object {
        fun newInstance() = ForgetPasswordFragment()
    }

    private val forgetPasswordFragVM: ForgetPasswordFragmentViewModel by lazy {
        ForgetPasswordFragmentViewModel(BaseApplication.getAppInstance()!!)
    }

}
