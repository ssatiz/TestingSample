package com.testing.sample.repository.todo.network

import com.testing.sample.Todo
import io.reactivex.Observable
import retrofit2.http.GET

interface TodoService {
    @GET("todos")
    fun getTodoList(): Observable<MutableList<Todo>>
}