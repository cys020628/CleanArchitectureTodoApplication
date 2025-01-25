package com.aladin.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert
    suspend fun insertTodoData(todoData: TodoEntity)

    @Query("SELECT * FROM todoTable")
    suspend fun getAllTodoData(): List<TodoEntity>

    @Delete
    suspend fun deleteTodoData(todoData: TodoEntity)
}