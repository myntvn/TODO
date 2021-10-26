package com.mynt.todo.data

import com.mynt.todo.data.source.TasksDataSource
import com.mynt.todo.domain.Result
import com.mynt.todo.domain.Task
import java.lang.Exception

object FakeTasksRemoteDataSource : TasksDataSource {

    private var TASKS_SERVICE_DATA: LinkedHashMap<String, Task> = LinkedHashMap()

    override suspend fun getTasks(): Result<List<Task>> {
        return Result.Success(TASKS_SERVICE_DATA.values.toList())
    }

    override suspend fun getTask(taskId: String): Result<Task> {
        TASKS_SERVICE_DATA[taskId]?.let {
            return Result.Success(it)
        }
        return Result.Error(Exception("Could not find task"))
    }

    override suspend fun saveTask(task: Task) {
        TASKS_SERVICE_DATA[task.id] = task
    }
}