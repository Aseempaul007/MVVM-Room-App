package com.example.mvvmroomapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmroomapp.repository.StudentRepository

class MainViewModelFactory(private val studentRepository: StudentRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(studentRepository) as T
    }
}