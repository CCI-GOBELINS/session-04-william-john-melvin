package com.example.reminderapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reminderapp.Reminder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomePageViewModel : ViewModel() {
    private val _reminders = MutableStateFlow<List<Reminder>>(emptyList())
    val reminders: StateFlow<List<Reminder>> = _reminders

    fun toggleCompletion(reminder: Reminder) {
        _reminders.value = _reminders.value.map {
            if (it.id == reminder.id){
                it.copy(completed = !it.completed)
            } else {
                it
            }
        }
    }
}


