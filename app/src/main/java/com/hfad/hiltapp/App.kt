package com.hfad.hiltapp

import android.app.Application

// TODO: Начало работы приложения

class App : Application() {

    lateinit var servicesLocator: ServicesLocator

    override fun onCreate() {
        super.onCreate()
        servicesLocator = ServicesLocator(applicationContext)
    }
}