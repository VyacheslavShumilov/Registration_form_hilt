package com.hfad.hiltapp

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import com.hfad.hiltapp.data.AppDatabase
import com.hfad.hiltapp.data.DataSource
import com.hfad.hiltapp.navigator.AppNavigator
import com.hfad.hiltapp.navigator.AppNavigatorImpl
import com.hfad.hiltapp.navigator.AppNavigatorPar

// TODO: Инициализация БД и связь с Main Activity

class ServicesLocator(context: Context) {

    private var loggingDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "users.db").build()

    var logDataSource = DataSource(loggingDatabase.userDao())

    // TODO: Для перехода между фрагментами (вызов в Main Activity)
    fun providerNavigator(fragmentActivity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(fragmentActivity)
    }

    fun providerNavigatorPar(fragmentActivity: FragmentActivity): AppNavigatorPar {
        return AppNavigatorImpl(fragmentActivity)
    }
}