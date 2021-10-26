package com.mynt.todo

import android.content.Context
import androidx.room.Room
import com.mynt.todo.data.FakeTasksRemoteDataSource
import com.mynt.todo.data.source.DefaultTasksRepository
import com.mynt.todo.data.source.TasksDataSource
import com.mynt.todo.data.source.local.TasksLocalDataSource
import com.mynt.todo.data.source.local.ToDoDatabase
import com.mynt.todo.domain.repository.TasksRepository

object ServiceLocator {
    private var database: ToDoDatabase? = null
    var tasksRepository: TasksRepository? = null

    fun provideTasksRepository(context: Context): TasksRepository {
        synchronized(this) {
            return tasksRepository ?: tasksRepository ?: createTasksRepository(context)
        }
    }

    private fun createTasksRepository(context: Context): TasksRepository {
        return DefaultTasksRepository(
            FakeTasksRemoteDataSource,
            createTasksLocalDataSource(context)
        )
    }

    private fun createTasksLocalDataSource(context: Context): TasksDataSource {
        val database = database ?: createDataBase(context)
        return TasksLocalDataSource(database.taskDao())
    }

    private fun createDataBase(context: Context): ToDoDatabase {
        val result = Room.databaseBuilder(
            context.applicationContext,
            ToDoDatabase::class.java,
            "Tasks.db"
        ).build()
        database = result
        return result
    }
}