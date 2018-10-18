package com.testing.sample.ui.todo

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseActivity
import com.testing.sample.base.BaseViewModel

class TodoListActivity : BaseActivity<ViewDataBinding, BaseViewModel>() {
    override fun getViewModel() = todoActVM

    override fun getBindingVariable() = BR.todoActVM

    override fun getContentView() = R.layout.activity_todo_list

    private val todoActVM: TodoActivityViewModel by lazy {
        TodoActivityViewModel(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)
    }
}
