package com.mynt.todo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mynt.todo.domain.repository.TasksRepository
import com.mynt.todo.domain.usecase.SaveTaskUseCase
import com.mynt.todo.presentation.addedittask.AddEditTaskViewModel
import kotlin.IllegalArgumentException

/**
 * Factory for all ViewModels.
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val tasksRepository: TasksRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(AddEditTaskViewModel::class.java) -> AddEditTaskViewModel(
                    SaveTaskUseCase(tasksRepository)
                )
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

}