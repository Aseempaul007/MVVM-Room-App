package com.example.mvvmroomapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val roll_no: Int,
    val standard: String

)
