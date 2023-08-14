package com.example.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.model.TodoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun selectAllTodo(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table WHERE id = :todoId")
    fun selectTodo(todoId: Int): Flow<TodoTask>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodo(todo: TodoTask)

    @Delete
    suspend fun deleteTodo(todo: TodoTask)

    @Update
    suspend fun updateTask(todo: TodoTask)

    @Query("DELETE  FROM todo_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")

    fun searchTodo(searchQuery: String):Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority():Flow<List<TodoTask>>
    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 3 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 1 END")
    fun sortByHighPriority():Flow<List<TodoTask>>

}