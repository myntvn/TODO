package com.mynt.todo.data.source.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mynt.todo.domain.Task

/**
 * Data Access Object for the tasks table
 */
interface TasksDao {

    /**
     * Select all tasks from tasks table.
     *
     * @return all tasks.
     */
    @Query("SELECT * FROM Tasks")
    suspend fun getTasks(): List<Task>

    /**
     * Select a task by id.
     *
     * @param taskId the task id.
     * @return the task with taskId.
     */
    @Query("SELECT * FROM Tasks WHERE entryid = :taskId")
    suspend fun getTaskById(taskId: String): Task?

    /**
     * Insert a task into the database. If the task already exists, replace it.
     *
     * @param task the task to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)
}