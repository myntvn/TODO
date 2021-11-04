package com.mynt.todo.presentation.extension

import androidx.fragment.app.Fragment
import com.mynt.todo.TodoApplication
import com.mynt.todo.presentation.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val repository = ((requireContext()).applicationContext as TodoApplication).tasksRepository
    return ViewModelFactory(repository)
}