package com.example.mvvmroomapp.repository

import android.content.Context
import com.example.mvvmroomapp.data.local.dao.StudentDao
import com.example.mvvmroomapp.data.local.entity.Student

class StudentRepository(private val studentDao: StudentDao) {

    suspend fun addStudent(student: Student){
        studentDao.addStudent(student)
    }

    suspend fun deleteStudent(context: Context){
        studentDao.deleteStudent()
    }

    suspend fun showStudents(context: Context): List<Student>{
        return studentDao.allStudents()
    }
}