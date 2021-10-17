package com.mynt.todo.domain.repository

import com.mynt.todo.domain.Task

interface TasksRepository {
    suspend fun saveTask(task: Task)
}