package com.mynt.todo

import android.app.Application
import com.mynt.todo.domain.repository.TasksRepository

class TodoApplication : Application() {

    // Depends on the flavor
    val tasksRepository: TasksRepository
        get() = ServiceLocator.provideTasksRepository(this)

}