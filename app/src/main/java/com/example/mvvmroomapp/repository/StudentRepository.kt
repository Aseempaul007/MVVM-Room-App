package com.example.mvvmroomapp.repository

import android.content.Context
import com.example.mvvmroomapp.data.local.dao.StudentDao
import com.example.mvvmroomapp.data.local.entity.Student
import javax.inject.Inject

class StudentRepository @Inject constructor(private val studentDao: StudentDao) {

    suspend fun addStudent(student: Student){
        studentDao.addStudent(student)
    }

    suspend fun deleteStudent(){
        studentDao.deleteStudent()
    }

    suspend fun showStudents(): List<Student>{
        return studentDao.allStudents()
    }
}