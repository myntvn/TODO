package com.mynt.todo.domain.usecase

import com.mynt.todo.domain.Task
import com.mynt.todo.domain.repository.TasksRepository

class SaveTaskUseCase(
    private val tasksRepository: TasksRepository
) {
    suspend operator fun invoke(task: Task) {
        return tasksRepository.saveTask(task);
    }
}