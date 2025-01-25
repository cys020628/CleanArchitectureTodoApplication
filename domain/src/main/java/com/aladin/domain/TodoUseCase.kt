package com.aladin.domain

import com.aladin.data.TodoEntity
import com.aladin.data.TodoRepository
import javax.inject.Inject

class TodoUseCase @Inject constructor(
    private val todoRepository: TodoRepository
){

    suspend fun getAllTodoData() = todoRepository.getAllTodoData()

    suspend fun addTodoData(todo: TodoEntity) = todoRepository.insertTodoData(todo)

    suspend fun removeTodoData(todo: TodoEntity) = todoRepository.deleteTodoData(todo)
}
