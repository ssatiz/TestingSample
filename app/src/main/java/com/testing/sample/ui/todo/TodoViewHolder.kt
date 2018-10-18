package com.testing.sample.ui.todo

import com.testing.sample.Todo
import com.testing.sample.base.BaseViewHolder
import com.testing.sample.databinding.ViewHolderTodoBinding

/**
 * Created by SunTrust on 10/18/2018.
 */
class TodoViewHolder(private val binding: ViewHolderTodoBinding) : BaseViewHolder<Todo>(binding.root) {
    override fun onBind(todo: Todo) {
    }
}