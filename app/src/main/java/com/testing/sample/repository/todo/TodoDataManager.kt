package com.testing.sample.repository.todo

import android.content.Context
import com.testing.sample.Todo
import com.testing.sample.repository.todo.network.TodoProvider
import com.testing.sample.repository.todo.network.TodoService
import io.reactivex.Observable

class TodoDataManager(context: Context, private val todoProvider: TodoProvider = TodoProvider(context)): TodoService{
    override fun getTodoList(): Observable<MutableList<Todo>> {
        return todoProvider.getTodoList()
    }
}