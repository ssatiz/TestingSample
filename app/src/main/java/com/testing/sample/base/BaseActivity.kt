package com.testing.sample.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders

/**
 * Created by SunTrust on 10/11/2018.
 */
abstract class BaseActivity<out V : ViewDataBinding, out T : BaseViewModel> : AppCompatActivity() {

    private var mDataBinding: V? = null
    private var mViewModel: T? = null

    abstract fun getViewModel(): T

    abstract fun getBindingVariable(): Int

    abstract fun getContentView(): Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, getContentView())
        mViewModel = ViewModelProviders.of(this).get(getViewModel()::class.java)
        mDataBinding?.setVariable(getBindingVariable(), mViewModel)
        mDataBinding?.executePendingBindings()
        mViewModel?.initialize(this)
    }


}