package com.aladin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoTable")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val todoId: Long = 0,
    val todoTask: String,
    val isCompleted: Boolean
)