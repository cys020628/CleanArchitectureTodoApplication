package com.aladin.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TodoModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(@ApplicationContext context: Context) : TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todoTable"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(todoDatabase: TodoDatabase):TodoDao {
        return todoDatabase.todoDao()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(todoDao: TodoDao):TodoRepository {
        return TodoRepository(todoDao)
    }
}