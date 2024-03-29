package com.testing.sample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by SunTrust on 10/11/2018.
 */
abstract class BaseFragment<out V : ViewDataBinding, out T : BaseViewModel> : Fragment() {

    private var mDataBinding: V? = null
    private var mViewModel: T? = null

    abstract fun getViewModel(): T

    abstract fun getBindingVariable(): Int

    abstract fun getContentView(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mDataBinding = DataBindingUtil.inflate(inflater, getContentView(), container, false)
        return mDataBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        mViewModel = getViewModel()
        mDataBinding?.setVariable(getBindingVariable(), mViewModel)
        mDataBinding?.executePendingBindings()
    }
}