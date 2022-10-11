package com.hfad.hiltapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}