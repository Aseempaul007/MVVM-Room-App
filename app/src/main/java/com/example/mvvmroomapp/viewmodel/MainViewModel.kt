package com.example.mvvmroomapp.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.mvvmroomapp.data.local.StudentDb
import com.example.mvvmroomapp.data.local.entity.Student
import com.example.mvvmroomapp.repository.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private var studentRepository: StudentRepository): ViewModel() {

    fun addStudent(id: Int, name: String, roll_no: Int, standard: String){
        viewModelScope.launch {
            studentRepository.addStudent(Student(id, name, roll_no, standard))
        }
    }

    fun deleteStudent(){
        viewModelScope.launch {
            studentRepository.deleteStudent()
        }
    }

    suspend fun showStudents(): List<Student>{
        return studentRepository.showStudents()
    }

}