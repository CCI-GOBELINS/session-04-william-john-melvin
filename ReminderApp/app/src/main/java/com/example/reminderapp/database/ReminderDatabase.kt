package com.example.reminderapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.reminderapp.Reminder

@Database(entities = [Reminder::class], version = 1, exportSchema = false)
abstract class ReminderDatabase : RoomDatabase() {
    abstract fun reminderDao(): ReminderDao


    companion object {

        @Volatile
        private var _INSTANCE: ReminderDatabase? = null

        val instance : ReminderDatabase
            get() = _INSTANCE!!

        fun initDatabase(context: Context): ReminderDatabase {
            return _INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ReminderDatabase::class.java,
                    "reminder_database"
                ).fallbackToDestructiveMigration()
                    .build()
                    .also { _INSTANCE = it }
                _INSTANCE = instance
                instance
            }
        }
    }

}
