package com.testing.sample.ui.todo

import android.os.Bundle
import androidx.lifecycle.Observer
import com.testing.sample.BR
import com.testing.sample.R
import com.testing.sample.base.BaseActivity
import com.testing.sample.databinding.ActivityTodoListBinding
import com.testing.sample.ui.todo.adapter.TodoListAdapter
import kotlinx.android.synthetic.main.activity_todo_list.*

class TodoListActivity : BaseActivity<ActivityTodoListBinding, TodoListActivityViewModel>() {
    override fun getViewModel() = todoListActVM

    override fun getBindingVariable() = BR.todoActVM

    override fun getContentView() = R.layout.activity_todo_list

    private val todoListActVM: TodoListActivityViewModel by lazy {
        obtainViewModel(TodoListActivityViewModel::class.java)
    }

    private val adapter by lazy {
        TodoListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        getViewModel().initialize(this)
        getViewModel().getTodoList()
        subscribeLiveData()
    }

    private fun setupRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun subscribeLiveData() {
        getViewModel().todoLiveData.observe(this, Observer {
            getViewModel().observeData(it)
        })
    }
}
