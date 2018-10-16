package com.testing.sample.ui.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseApplication
import com.testing.sample.base.BaseFragment
import com.testing.sample.base.BaseViewModel
import com.testing.sample.ui.login.LoginActivity
import kotlinx.android.synthetic.main.registration_fragment.*

class RegistrationFragment : BaseFragment<ViewDataBinding, BaseViewModel>(),View.OnClickListener {
    override fun getViewModel(): BaseViewModel {
        return registrationFragVM
    }

    override fun getBindingVariable(): Int {
        return BR.registrationFragVM
    }

    override fun getContentView(): Int {
        return R.layout.registration_fragment
    }

    companion object {
        fun newInstance() = RegistrationFragment()
    }

    private val registrationFragVM: RegistrationFragmentViewModel by lazy {
        RegistrationFragmentViewModel(BaseApplication.getAppInstance()!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnBack->{
               activity?.finish()
            }
        }
    }
}
