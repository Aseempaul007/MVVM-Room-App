package com.example.mvvmroomapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmroomapp.data.local.StudentDb
import com.example.mvvmroomapp.data.local.dao.StudentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {


    @Provides
    @Singleton
    fun provideRoomInstance(@ApplicationContext context: Context): StudentDb{
        synchronized(this){
            return Room.databaseBuilder(
                context,
                StudentDb::class.java,
                "student_db"
            ).build()
        }
    }

    @Provides
    fun providesStudentDao(studentDb: StudentDb): StudentDao{
        return studentDb.dao()
    }
}