package com.testing.sample.ui.registration

import android.os.Bundle
import android.view.View
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseApplication
import com.testing.sample.base.BaseFragment
import com.testing.sample.databinding.FragmentRegistrationBinding
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : BaseFragment<FragmentRegistrationBinding, RegistrationFragmentViewModel>(), View.OnClickListener {
    override fun getViewModel() = registrationFragVM

    override fun getBindingVariable() = BR.registrationFragVM
    override fun getContentView() = R.layout.fragment_registration

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
        when (v?.id) {
            R.id.btnBack -> {
                activity?.onBackPressed()
            }
        }
    }
}
