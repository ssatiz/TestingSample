package com.testing.sample.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.testing.sample.helper.ViewModelFactory

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
        mViewModel = getViewModel()
        mDataBinding?.setVariable(getBindingVariable(), mViewModel)
        mDataBinding?.executePendingBindings()
    }

    protected fun setFragment(@IdRes containerViewId:Int, fragment: Fragment, isAddToBackStack: Boolean = false, tagString: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(containerViewId, fragment)
        if (isAddToBackStack) transaction.addToBackStack(tagString)
        transaction.commit()
    }


    companion object {
        fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
                ViewModelProviders.of(this, ViewModelFactory.getInstance()).get(viewModelClass)
    }


}