package com.aladin.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aladin.data.TodoEntity
import com.aladin.domain.TodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoUseCase: TodoUseCase
):ViewModel() {
    private val _todoData = MutableStateFlow<List<TodoEntity>>(emptyList())
    val todoData: StateFlow<List<TodoEntity>> = _todoData

    init {
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch {
            _todoData.value = todoUseCase.getAllTodoData()
        }
    }

    fun addTodo(task: String) {
        viewModelScope.launch {
            val todo = TodoEntity(todoTask = task, isCompleted = false)
            todoUseCase.addTodoData(todo)
            getTodos()
        }
    }

    fun removeTodo(todo: TodoEntity) {
        viewModelScope.launch {
            todoUseCase.removeTodoData(todo)
            getTodos()
        }
    }
}