package com.mynt.todo.presentation.addedittask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddEditTaskViewModel(): ViewModel() {

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()
}