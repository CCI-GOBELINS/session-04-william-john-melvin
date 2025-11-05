package com.example.reminderapp.di

import android.content.Context
import com.example.reminderapp.database.ReminderDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn
object ReminderModule {
    @Provides
    fun providesDatabase(@ApplicationContext context : Context): ReminderDatabase{
        return ReminderDatabase.initDatabase(context)
    }
}