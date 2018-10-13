package com.testing.sample.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.google.android.material.button.MaterialButton
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseApplication
import com.testing.sample.base.BaseFragment
import com.testing.sample.base.BaseViewModel
import com.testing.sample.ui.forgetPassword.ForgetPasswordActivity
import com.testing.sample.ui.registration.RegistrationActivity

class LoginFragment : BaseFragment<ViewDataBinding, BaseViewModel>() {
    override fun getViewModel(): BaseViewModel {
        return loginFragVM
    }

    override fun getBindingVariable(): Int {
        return BR.loginFragVM
    }

    override fun getContentView(): Int {
        return R.layout.login_fragment
    }

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val loginFragVM: LoginFragmentViewModel by lazy {
        LoginFragmentViewModel(BaseApplication.getAppInstance()!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialButton>(R.id.btnForgetPassword).setOnClickListener {
            startActivity(Intent(activity, ForgetPasswordActivity::class.java))
        }

        view.findViewById<MaterialButton>(R.id.btnRegister).setOnClickListener {
            startActivity(Intent(activity, RegistrationActivity::class.java))
        }
    }
}
