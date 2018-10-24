package com.testing.sample.ui.todo

import android.content.Context
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.testing.sample.Todo
import com.testing.sample.base.BaseViewModel
import com.testing.sample.repository.todo.TodoDataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by SunTrust on 10/18/2018.
 */
class TodoListActivityViewModel : BaseViewModel() {
    private var todoDataManager: TodoDataManager? = null
    val todoLiveData = MutableLiveData<MutableList<Todo>>()

    var todoObservableList: ObservableList<Todo> = ObservableArrayList<Todo>()

    override fun initialize(context: Context) {
        super.initialize(context)
        todoDataManager = TodoDataManager()
    }

    fun getTodoList() {
        todoDataManager?.getTodoList()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe { it ->
            it?.let {
                todoLiveData.value = it
            }
        }
    }

    fun observeData(todoList: MutableList<Todo>) {
        todoObservableList.clear()
        todoObservableList.addAll(todoList)
    }
}