package com.testing.sample.helper


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.testing.sample.ui.forgetPassword.ForgetPasswordFragmentViewModel
import com.testing.sample.ui.login.LoginActivityViewModel
import com.testing.sample.ui.login.LoginFragmentViewModel
import com.testing.sample.ui.registration.RegistrationFragmentViewModel
import com.testing.sample.ui.todo.TodoListActivityViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor() : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(LoginActivityViewModel::class.java) ->
                        LoginActivityViewModel()
                    isAssignableFrom(TodoListActivityViewModel::class.java) ->
                        TodoListActivityViewModel()
                    isAssignableFrom(LoginFragmentViewModel::class.java) ->
                        LoginFragmentViewModel()
                    isAssignableFrom(RegistrationFragmentViewModel::class.java) ->
                        RegistrationFragmentViewModel()
                    isAssignableFrom(ForgetPasswordFragmentViewModel::class.java) ->
                        ForgetPasswordFragmentViewModel()
                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T

    companion object {

        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance() =
                INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE ?: ViewModelFactory()
                            .also { INSTANCE = it }
                }
    }
}
