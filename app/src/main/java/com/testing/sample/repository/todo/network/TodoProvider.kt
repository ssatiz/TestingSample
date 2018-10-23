package com.testing.sample.repository.todo.network

import android.content.Context
import com.testing.sample.Todo
import com.testing.sample.base.BaseRetrofit
import io.reactivex.Observable

open class TodoProvider(con: Context) : BaseRetrofit() {

    private fun getService(): TodoService {
        return buildRetrofit().create(TodoService::class.java)
    }

    fun getTodoList(): Observable<MutableList<Todo>> {
        return getService().getTodoList().doOnNext { }
    }

}