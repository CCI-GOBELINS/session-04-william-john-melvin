package com.example.reminderapp.database

import androidx.room.*
import com.example.reminderapp.Reminder

@Dao
interface ReminderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)

    @Query("SELECT * FROM reminder_table ORDER BY name ASC")
    fun getAllReminders(): kotlinx.coroutines.flow.Flow<List<Reminder>>
}