package com.testing.sample.ui.todo.adapter

import androidx.databinding.ObservableField
import com.testing.sample.Todo

class TodoDataModel(todo: Todo) {
    val title: ObservableField<String> = ObservableField(todo.title)
}