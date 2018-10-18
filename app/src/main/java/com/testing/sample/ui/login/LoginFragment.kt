package com.testing.sample.ui.login

import android.os.Bundle
import android.view.View
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseApplication
import com.testing.sample.base.BaseFragment
import com.testing.sample.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginFragmentViewModel>(), View.OnClickListener {
    override fun getViewModel(): LoginFragmentViewModel {
        return loginFragVM
    }

    override fun getBindingVariable(): Int {
        return BR.loginFragVM
    }

    override fun getContentView(): Int {
        return R.layout.fragment_login
    }

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val loginFragVM: LoginFragmentViewModel by lazy {
        LoginFragmentViewModel(BaseApplication.getAppInstance()!!)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnForgetPassword.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnForgetPassword -> {
                (activity as LoginActivity).redirectToFrogetPassword()
            }
            R.id.btnRegister -> {
                (activity as LoginActivity).redirectToRegistration()
            }
        }
    }
}
