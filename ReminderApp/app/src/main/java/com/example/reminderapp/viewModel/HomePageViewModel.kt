package com.example.reminderapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reminderapp.Data
import com.example.reminderapp.Reminder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomePageViewModel : ViewModel() {

    fun toggleCompletion(reminder: Reminder) {
        val index = Data.reminders.indexOfFirst { it.id == reminder.id }
        if (index != -1) {
            Data.reminders[index] = reminder.copy(completed = !reminder.completed)
        }
    }
}



