package com.testing.sample.ui.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testing.sample.Todo
import com.testing.sample.databinding.ViewHolderTodoBinding
import com.testing.sample.ui.todo.adapter.TodoViewHolder

class TodoListAdapter: RecyclerView.Adapter<TodoViewHolder>(){

    private val todoList = ArrayList<Todo>()

    fun addAll(todoList: ArrayList<Todo>){
        this.todoList.addAll(todoList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val todoHolder = ViewHolderTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(todoHolder)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.onBind(todoList.get(position))
    }

}