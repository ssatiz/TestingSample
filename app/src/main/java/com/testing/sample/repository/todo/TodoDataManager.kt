package com.testing.sample.repository.todo

import com.testing.sample.Todo
import com.testing.sample.repository.todo.network.TodoProvider
import com.testing.sample.repository.todo.network.TodoService
import io.reactivex.Observable

class TodoDataManager(private val todoProvider: TodoProvider = TodoProvider()) : TodoService {
    override fun getTodoList(): Observable<MutableList<Todo>> {
        return todoProvider.getTodoList()
    }
}