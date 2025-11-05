package com.example.reminderapp

import android.app.Application
import com.example.reminderapp.database.ReminderDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ReminderDatabase.getInstance(this)
    }

}