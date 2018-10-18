package com.testing.sample.helper

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.testing.sample.Todo
import com.testing.sample.ui.todo.adapter.TodoListAdapter

@BindingAdapter("todos")
fun refreshBindingValue(recyclerView: RecyclerView, todoList: ArrayList<Todo>){
    val adapter = recyclerView.adapter as? TodoListAdapter
    adapter?.addAll(todoList)
}