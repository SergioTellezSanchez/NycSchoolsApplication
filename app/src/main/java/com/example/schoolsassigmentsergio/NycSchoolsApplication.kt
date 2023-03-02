package com.example.schoolsassigmentsergio

import android.app.Application
import com.example.schoolsassigmentsergio.dataManager.AppContainer
import com.example.schoolsassigmentsergio.dataManager.DefaultAppContainer

class NycSchoolsApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}