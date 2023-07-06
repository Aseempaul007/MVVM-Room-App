package com.example.mvvmroomapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmroomapp.data.local.entity.Student

@Dao
interface StudentDao {

    @Insert
    suspend fun addStudent(student: Student)

    @Query("SELECT * FROM student")
    suspend fun allStudents(): List<Student>

    @Query("Delete FROM student")
    suspend fun deleteStudent()
}