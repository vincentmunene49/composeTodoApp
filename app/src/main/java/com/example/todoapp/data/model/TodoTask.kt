package com.example.todoapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoapp.util.Constants

@Entity(tableName = Constants.DATABASE_TABLE_NAME)
data class TodoTask(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val description:String,
    val priority: Priority

)
