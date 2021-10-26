package com.mynt.todo.presentation.addedittask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mynt.todo.domain.Task
import com.mynt.todo.domain.usecase.SaveTaskUseCase
import kotlinx.coroutines.launch

class AddEditTaskViewModel(private val saveTaskUseCase: SaveTaskUseCase) : ViewModel() {

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    private fun createTask(newTask: Task) = viewModelScope.launch {
        saveTaskUseCase(newTask)
    }
}