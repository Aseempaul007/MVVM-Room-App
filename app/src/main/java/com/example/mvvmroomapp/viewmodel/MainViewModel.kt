package com.example.mvvmroomapp.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.mvvmroomapp.data.local.StudentDb
import com.example.mvvmroomapp.data.local.entity.Student
import com.example.mvvmroomapp.repository.StudentRepository

class MainViewModel(val context: Context): ViewModel() {

    private val studentRepository = StudentRepository(StudentDb.getInstance(context).dao())

    suspend fun addStudent(id: Int, name: String, roll_no: Int, standard: String){
        studentRepository.addStudent(Student(id,name,roll_no,standard))
    }

    suspend fun deleteStudent(){
        studentRepository.deleteStudent(context)
    }

    suspend fun showStudents():List<Student>{
        return studentRepository.showStudents(context)
    }

}