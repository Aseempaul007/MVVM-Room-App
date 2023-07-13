package com.example.mvvmroomapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmroomapp.data.local.dao.StudentDao
import com.example.mvvmroomapp.data.local.entity.Student

@Database(
    entities = [Student::class],
    version = 1
)
abstract class StudentDb: RoomDatabase() {
    abstract fun dao(): StudentDao
}