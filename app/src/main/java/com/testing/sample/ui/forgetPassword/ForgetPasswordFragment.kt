package com.testing.sample.ui.forgetPassword

import android.os.Bundle
import android.view.View
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseApplication
import com.testing.sample.base.BaseFragment
import com.testing.sample.databinding.FragmentForgetPasswordBinding
import kotlinx.android.synthetic.main.fragment_forget_password.*

class ForgetPasswordFragment : BaseFragment<FragmentForgetPasswordBinding, ForgetPasswordFragmentViewModel>(), View.OnClickListener {

    override fun getViewModel(): ForgetPasswordFragmentViewModel {
        return forgetPasswordFragVM
    }

    override fun getBindingVariable(): Int {
        return BR.forgetPasswordFragVM
    }

    override fun getContentView(): Int {
        return R.layout.fragment_forget_password
    }

    companion object {
        fun newInstance() = ForgetPasswordFragment()
    }

    private val forgetPasswordFragVM: ForgetPasswordFragmentViewModel by lazy {
        ForgetPasswordFragmentViewModel(BaseApplication.getAppInstance()!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnBack -> {
                activity?.onBackPressed()
            }
        }
    }
}
