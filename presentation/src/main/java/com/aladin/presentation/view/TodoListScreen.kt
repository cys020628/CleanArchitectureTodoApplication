package com.aladin.presentation.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aladin.presentation.viewModel.TodoViewModel

@Composable
fun TodoScreen(todoViewModel: TodoViewModel = hiltViewModel()) {
    val todoList by todoViewModel.todoData.collectAsState()
    val showDialog = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            // 상단 바
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize().padding(it)
            ) {
                // 리스트 보여주기
                LazyColumn {
                    items(todoList) { todo ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = todo.todoTask,
                                modifier = Modifier.weight(1f)
                            )
                            Button(
                                onClick = {
                                    todoViewModel.removeTodo(todo)
                                }
                            ) {
                                Text(text = "Delete")
                            }
                        }
                    }
                }

                Button(
                    onClick = {
                        showDialog.value = true
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Add Task")
                }
            }

            if (showDialog.value) {
                AddTaskDialog(
                    onDismiss = { showDialog.value = false },
                    onAddTask = { task ->
                        todoViewModel.addTodo(task)
                        showDialog.value = false
                    }
                )
            }
        }
    )
}

@Composable
fun AddTaskDialog(onDismiss: () -> Unit, onAddTask: (String) -> Unit) {
    var taskText by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Add New Task")
        },
        text = {
            TextField(
                value = taskText,
                onValueChange = { taskText = it },
                label = { Text("Task") }
            )
        },
        confirmButton = {
            Button(
                onClick = {
                    if (taskText.isNotBlank()) {
                        onAddTask(taskText)
                    }
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}