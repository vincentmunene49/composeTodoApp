package com.example.todoapp.repositories

import com.example.todoapp.data.TodoDao
import com.example.todoapp.data.model.TodoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepository @Inject constructor( val todoDao: TodoDao) {

    val getAllTodos:Flow<List<TodoTask>> = todoDao.selectAllTodo()
    val sortByLowPriority:Flow<List<TodoTask>> = todoDao.sortByLowPriority()
    val sortByHighPriority:Flow<List<TodoTask>> = todoDao.sortByHighPriority()

    fun returnGivenTask(id:Int):Flow<TodoTask> {
        return todoDao.selectTodo(id)
    }

    suspend fun addTask(todoTask: TodoTask){
        todoDao.addTodo(todoTask)
    }
    suspend fun updateTask(todoTask: TodoTask){
        todoDao.updateTask(todoTask)
    }
    suspend fun deleteTask(todoTask: TodoTask){
        todoDao.deleteTodo(todoTask)
    }
    suspend fun deleteAllTask(){
        todoDao.deleteAll()
    }

    fun searchDb(searchQuery:String):Flow<List<TodoTask>>{
        return  todoDao.searchTodo(searchQuery)
    }
}