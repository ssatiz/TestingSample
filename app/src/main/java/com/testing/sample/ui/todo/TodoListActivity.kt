package com.testing.sample.ui.todo

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.testing.sample.BR
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.testing.sample.R
import com.testing.sample.base.BaseActivity
import com.testing.sample.base.BaseViewModel
import com.testing.sample.databinding.ActivityTodoListBinding
import com.testing.sample.ui.todo.adapter.TodoListAdapter
import kotlinx.android.synthetic.main.activity_todo_list.*

class TodoListActivity : BaseActivity<ActivityTodoListBinding, TodoActivityViewModel>() {
    override fun getViewModel() = todoActVM

    override fun getBindingVariable() = BR.todoActVM

    override fun getContentView() = R.layout.activity_todo_list

    private val todoActVM: TodoActivityViewModel by lazy {
        TodoActivityViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        getViewModel().initialize(this)
        getViewModel().getTodoList()
        subscribeLiveData()
    }

    private fun setupRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = TodoListAdapter()
    }

    private fun subscribeLiveData(){
        getViewModel().todoLiveData.observe(this, Observer {
            getViewModel().observeData(it)
        })
    }
}
