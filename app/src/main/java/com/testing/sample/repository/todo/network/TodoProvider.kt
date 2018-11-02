package com.testing.sample.repository.todo.network

import com.bpmlinks.utility.network.BaseRetrofit
import com.testing.sample.Todo
import io.reactivex.Observable

open class TodoProvider : BaseRetrofit() {

    private fun getService(): TodoService {
        return buildRetrofit().create(TodoService::class.java)
    }

    fun getTodoList(): Observable<MutableList<Todo>> {
        return getService().getTodoList().doOnNext { }
    }

}