package com.testing.sample.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseFragment
import com.testing.sample.databinding.FragmentLoginBinding
import com.testing.sample.ui.todo.TodoListActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginFragmentViewModel>(), View.OnClickListener {
    override fun getViewModel() = loginFragVM

    override fun getBindingVariable() = BR.loginFragVM

    override fun getContentView() = R.layout.fragment_login

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val loginFragVM: LoginFragmentViewModel by lazy {
        obtainViewModel(LoginFragmentViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnForgetPassword.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNext -> {
                startActivity(Intent(activity, TodoListActivity::class.java))
            }
            R.id.btnForgetPassword -> {
                (activity as LoginActivity).redirectToForgetPassword()
            }
            R.id.btnRegister -> {
                (activity as LoginActivity).redirectToRegistration()
            }
        }
    }
}
