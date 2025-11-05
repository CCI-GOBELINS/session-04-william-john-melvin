package com.example.reminderapp.viewModel

import android.app.Application
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reminderapp.Reminder
import com.example.reminderapp.database.ReminderDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MyHomePageViewModel() : ViewModel(){
    lateinit var allReminders : Flow<List<Reminder>>
    init {
        val dao = ReminderDatabase.instance.reminderDao()
        viewModelScope.launch {
            allReminders = MutableStateFlow(dao.getAllReminders())
        }
    }

}