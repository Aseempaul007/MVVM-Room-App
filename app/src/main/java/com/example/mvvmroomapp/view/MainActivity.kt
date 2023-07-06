package com.example.mvvmroomapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.mvvmroomapp.R
import com.example.mvvmroomapp.data.local.StudentDb
import com.example.mvvmroomapp.data.local.entity.Student
import com.example.mvvmroomapp.databinding.ActivityMainBinding
import com.example.mvvmroomapp.repository.StudentRepository
import com.example.mvvmroomapp.viewmodel.MainViewModel
import com.example.mvvmroomapp.viewmodel.MainViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var database: StudentDb
    lateinit var mainViewModel: MainViewModel
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        var studentRepository = StudentRepository(StudentDb.getInstance(applicationContext).dao())
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(studentRepository)
        ).get(MainViewModel::class.java)
        database = StudentDb.getInstance(applicationContext)

        mainBinding.btn1.setOnClickListener {
            mainViewModel.addStudent(
                mainBinding.id.text.toString().toInt(),
                mainBinding.name.text.toString(),
                mainBinding.rollNo.text.toString().toInt(),
                mainBinding.standard.text.toString()
            )
        }

        mainBinding.btn2.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("Student_ATG", mainViewModel.showStudents().toString())
            }
        }

        mainBinding.btn3.setOnClickListener {
            mainViewModel.deleteStudent()
        }

    }

}