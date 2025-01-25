package com.aladin.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepository @Inject constructor(
    private val todoDao: TodoDao
) {
    suspend fun getAllTodoData(): List<TodoEntity> = todoDao.getAllTodoData()

    suspend fun insertTodoData(todoEntity: TodoEntity) = todoDao.insertTodoData(todoEntity)

    suspend fun deleteTodoData(todoEntity: TodoEntity) = todoDao.deleteTodoData(todoEntity)
}