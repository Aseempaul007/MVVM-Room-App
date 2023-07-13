package com.example.mvvmroomapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmroomapp.data.local.StudentDb
import com.example.mvvmroomapp.databinding.ActivityMainBinding
import com.example.mvvmroomapp.repository.StudentRepository
import com.example.mvvmroomapp.util.Constants.MY_TAG
import com.example.mvvmroomapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var database: StudentDb
    @Inject
    lateinit var studentRepository: StudentRepository

    lateinit var mainViewModel: MainViewModel
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

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
                Log.d(MY_TAG, mainViewModel.showStudents().toString())
            }
        }

        mainBinding.btn3.setOnClickListener {
            mainViewModel.deleteStudent()
        }

    }

}