package com.mynt.todo.data.source

import com.mynt.todo.domain.Result
import com.mynt.todo.domain.Task

interface TasksDataSource {
    suspend fun getTasks(): Result<List<Task>>

    suspend fun getTask(taskId: String): Result<Task>

    suspend fun saveTask(task: Task)
}