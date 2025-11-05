package com.example.reminderapp

import android.app.Application
import com.example.reminderapp.database.ReminderDatabase

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ReminderDatabase.getInstance(this)
    }

}