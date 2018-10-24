package com.testing.sample.helper

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.testing.sample.Todo
import com.testing.sample.ui.todo.adapter.TodoListAdapter

@BindingAdapter("todos")
fun refreshBindingValue(recyclerView: RecyclerView, todoList: ObservableList<Todo>) {
    recyclerView.adapter?.let {
        val adapter = it as? TodoListAdapter
        adapter?.addAll(ArrayList(todoList))
    }
}