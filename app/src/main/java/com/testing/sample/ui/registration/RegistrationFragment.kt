package com.testing.sample.ui.registration

import androidx.databinding.ViewDataBinding
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseApplication
import com.testing.sample.base.BaseFragment
import com.testing.sample.base.BaseViewModel

class RegistrationFragment : BaseFragment<ViewDataBinding, BaseViewModel>() {
    override fun getViewModel(): BaseViewModel {
        return registrationFVM
    }

    override fun getBindingVariable(): Int {
        return BR.registrationFVM
    }

    override fun getContentView(): Int {
        return R.layout.registration_fragment
    }

    companion object {
        fun newInstance() = RegistrationFragment()
    }

    private val registrationFVM: RegistrationFragmentViewModel by lazy {
        RegistrationFragmentViewModel(BaseApplication.getAppInstance()!!)
    }
}
